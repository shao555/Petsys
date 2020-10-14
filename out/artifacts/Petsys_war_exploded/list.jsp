<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/14
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

        // $(document).ready(function () {
        //     $("table").attr("bgColor", "#FFFFFF"); //设置表格的背景颜色
        //     $("tr").attr("bgColor", "#B6B6B6"); //为单数行表格设置背景颜色
        //     $("tr:even").css("background-color", "#9A9A9A"); //为双数行表格设置背颜色素
        //     $("table").css("width", "600px")
        // }); //为表格添加样式，设置表格长度为300像素
    </script>

</head>
<body>

<form action="PetServlet" method="post">
    <p align="center"><span>品种</span>&nbsp;&nbsp;
        <select id="sel" name="sel">
            <option value="0">--请选择--</option>
            <option value="1"
                    <:c:if test="${p.petBreed==1}"> <%--selected--%> </:c:if>
            >狗
            </option>
            <option value="2"
                    <:c:if test="${p.petBreed==2}"> <%--selected--%> </:c:if>
            >猫
            </option>
            <option value="3"
                    <:c:if test="${p.petBreed==3}"> <%--selected--%> </:c:if>
            >鸟
            </option>
            <option value="4"
                    <:c:if test="${p.petBreed==4}"> <%--selected--%> </:c:if>
            >龟
            </option>
        </select>&nbsp;&nbsp;
        <input type="submit" name="comm" value="查询">&nbsp;&nbsp;<a href="">新增宠物</a>
    </p>

    <table align="center" width="500" border="1px">
        <tr>
            <td><strong>宠物昵称</strong></td>
            <td><strong>出生日期</strong></td>
            <td><strong>性别</strong></td>
        </tr>
        <c:forEach items="${list}" var="p">
            <tr>
                <td>${p.petName}</td>
                <td>${p.birthday}</td>
                <c:if test="${p.petSex==1}">
                    <td width="100">雄</td>
                </c:if>
                <c:if test="${p.petSex==2}">
                    <td width="100">雌</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>
