package com.sri.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sri.controller.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHelloworld() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
//		MvcResult mvcResult = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andReturn()
//				;
		
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hell0 World!!"))
				.andReturn()
				;

//		System.out.println(mvcResult.getResponse().getContentAsString());
//		assertEquals(mvcResult.getResponse().getContentAsString(), "Hell0 World!!");
	}
}
