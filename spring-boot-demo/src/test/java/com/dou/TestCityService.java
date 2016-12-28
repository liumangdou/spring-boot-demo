package com.dou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dou.entity.City;
import com.dou.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration 
public class TestCityService {
	private static final Logger log = LoggerFactory.getLogger(TestCityService.class) ;
	
	@Autowired
	@Qualifier("cityService")
    private ICityService cityService;
	
	@Test
	public void testGetById() throws Exception{
		try {
			log.debug("---------------------------------"+cityService.getById(1).getName());
			int i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		try {
			City c = new City();
			c.setName("李四");
			c.setState("中国");
			c.setCountry("中国");
			cityService.insert(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
