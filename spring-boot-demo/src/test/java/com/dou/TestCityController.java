package com.dou;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dou.web.CityController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestCityController {
	private MockMvc mvc;
	
	@Autowired
    private CityController cityController;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.standaloneSetup(cityController).build();
	}
	
	@Test
	public void testCreate() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/city/create"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
	
	/*@Test
	public void testGetById() throws Exception{
		mvc.perform(
				MockMvcRequestBuilders.get("/city/get/1")
			).andDo(MockMvcResultHandlers.print())
			.andReturn();
	}*/

}
