package com.cs.test;

import com.cs.entity.Pet;
import com.cs.service.impl.PetServiceImpl;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {



        findByBreed();

//        add();


    }

    private static void add() throws Exception {
        PetServiceImpl psi = new PetServiceImpl();
        Pet pet = new Pet();
        pet.setPetName("元十三的狗");
        pet.setPetBreed(1);
        pet.setPetSex(2);
        Date d=new Date(110,1,25);
        pet.setBirthday(d);
        pet.setDescription("元十三的狗是狗");
        int i = psi.addPet(pet);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    private static void findByBreed() throws Exception {
        PetServiceImpl psi = new PetServiceImpl();
        List<Pet> list = psi.findInfoByBreed(0);
        for (Pet p : list) {
            System.out.println(p.getPetName() + " " + p.getBirthday()
             + " " + p.getPetSex());
        }
    }






}


