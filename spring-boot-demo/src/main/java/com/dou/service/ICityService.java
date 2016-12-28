package com.dou.service;

import com.dou.entity.City;

public interface ICityService {
	City getById(int id);

	void insert(City city);

	void insertReadOnly(City city);

	void insertAndGet(City city);

}
