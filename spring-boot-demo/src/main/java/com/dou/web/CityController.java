package com.dou.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dou.entity.City;
import com.dou.service.ICityService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	@Qualifier(value="cityService")
	private ICityService cityService;
	
	@ApiOperation(value="查询城市信息", notes="根据用户ID获取城市信息")
	@ApiImplicitParam(name="id", value="用户id", required=true, dataType="Integer")
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	public City getById(@PathVariable Integer id){
		City c = cityService.getById(id);
		System.out.println(c.getName());
		return c;
	}
	
	@ApiOperation(value="创建城市信息", notes="创建城市信息")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public City Create(){
		City c = new City();
		c.setName("张三");
		c.setState("中国");
		c.setCountry("中国");
		cityService.insert(c);
		System.out.println(c.getName());
		return c;
	}
}
