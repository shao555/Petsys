package com.cs.service.impl;

import com.cs.dao.impl.PetDaoImpl;
import com.cs.entity.Pet;
import com.cs.service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {

    PetDaoImpl pdi = new PetDaoImpl();


    @Override
    public List<Pet> findInfoByBreed(int petBreed) throws Exception {
        return pdi.findInfoByBreed(petBreed);
//        return null;
    }

    @Override
    public int addPet(Pet pet) throws Exception {
        return pdi.addPet(pet);
//        return 0;
    }
}
