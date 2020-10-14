package com.cs.servlet;

import com.cs.entity.Pet;
import com.cs.service.impl.PetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PetServlet",urlPatterns = "/PetServlet")
public class PetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PetServiceImpl psi = new PetServiceImpl();
        String comm =request.getParameter("comm");
//        String bre = request.getParameter("breed");
//        int br = Integer.parseInt(bre);
        if ("list".equals(comm)) {
            try {
                List<Pet> list = psi.findInfoByBreed(0);
                if (list != null && list.size()>0) {
                    request.getSession().setAttribute("list",list);
                    request.getRequestDispatcher("list.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("查询".equals(comm)) {
            String sel = request.getParameter("sel");
            int se = Integer.parseInt(sel);
            System.out.println("se " + se);
            try {
                List<Pet> list = psi.findInfoByBreed(se);
//                System.out.println("list=" + list);
                if (list != null && list.size()>0) {
                    request.getSession().setAttribute("list",list);
                    request.getRequestDispatcher("list.jsp").forward(request,response);
                } else {
                    request.getSession().setAttribute("list",list);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
