package com.cs.service;

import com.cs.entity.Pet;

import java.util.List;

public interface PetService {

    //根据品种查询方法
    public List<Pet> findInfoByBreed(int petBreed) throws Exception;

    //添加关键词方法
    public int addPet(Pet pet) throws Exception;

}
