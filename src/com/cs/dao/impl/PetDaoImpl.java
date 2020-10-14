package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.PetDao;
import com.cs.entity.Pet;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PetDaoImpl extends BaseDao implements PetDao {


    //根据品种查询方法
    @Override
    public List<Pet> findInfoByBreed(int petBreed) throws Exception {
        List<Pet> list =new ArrayList<>();
        Pet pet = null;
        ResultSet rs = null;
        if (petBreed == 0) {
            String sql = "select * from Pet";
            Object[] obj = null;
            rs = execQuery(sql, obj);
        } else {
            String sql = "select * from Pet where PetBreed = ?";
            Object[] obj = {petBreed};
            rs = execQuery(sql, obj);
        }
        while (rs.next()) {
            pet = new Pet();
            pet.setId(rs.getInt(1));
            pet.setPetName(rs.getString(2));
            pet.setPetBreed(rs.getInt(3));
            pet.setPetSex(rs.getInt(4));
            pet.setBirthday(rs.getDate(5));
            pet.setDescription(rs.getString(6));
            list.add(pet);
        }
        getClose();
        return list;
//        return null;
    }

    //添加关键词方法
    @Override
    public int addPet(Pet pet) throws Exception {
        int index = -1;
        String sql = "INSERT INTO Pet(PetName,PetBreed,PetSex,Birthday,Description)VALUE(?,?,?,?,?);";
        Object[] obj = {pet.getPetName(),pet.getPetBreed(),pet.getPetSex(),pet.getBirthday(),pet.getDescription()};
        index = execUpdate(sql,obj);
        getClose();
        return index;
//        return 0;
    }

}
