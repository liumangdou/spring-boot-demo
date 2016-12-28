package com.dou.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dou.entity.City;

@Mapper
public interface CityMapper {
	
    City getById(int id);
    
    void insert(City city);
}
