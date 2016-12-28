package com.dou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dou.dao.CityMapper;
import com.dou.entity.City;
import com.dou.service.ICityService;


@Service("cityService")
public class CityServiceImpl implements ICityService {
	@Autowired
	private CityMapper cityMapper;
	
	@Transactional
	@Override
	public City getById(int id) {
		return cityMapper.getById(id);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void insert(City city) {
		cityMapper.insert(city);
	}
	
	@Override
	public void insertReadOnly(City city) {
		cityMapper.insert(city);
	}
	
	@Override
	public void insertAndGet(City city) {
		cityMapper.insert(city);
	}
	
}
