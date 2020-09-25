package com.sri.unittesting.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sri.controller.ItemController;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void Item_test() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk())

				.andReturn();

		System.out.println(mvcResult.getResponse().getContentAsString());
	}

	// here spaces are allowed but content should match with all the properties
	@Test
	public void Item_test_with_JSON_Assert() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk())

				.andReturn();

//		System.out.println(mvcResult.getResponse().getContentAsString());
		String expected = "{\"id\": 1,\"name\":\"Basket\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), true);
	}

	// here spaces are allowed and partial content is fine and should match with all
	// the properties
	@Test
	public void Item_test_with_JSON_Assert_with_false() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk())

				.andReturn();

//		System.out.println(mvcResult.getResponse().getContentAsString());
		String expected = "{\"id\": 1,\"name\":\"Basket\",\"price\":11}";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}
}
