package com.sri.unittesting.controller;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sri.business.ItemBusinessService;
import com.sri.controller.ItemController;
import com.sri.model.Item;
import com.sri.repository.ItemRepository;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ItemBusinessService ItemBusinessService;

//	@MockBean
//	private ItemRepository itemReposiotory;

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

	@Test
	public void Item_test_with_JSON_Assert_with_business_service() throws Exception {

		when(ItemBusinessService.getHardCodedItem()).thenReturn(new Item(1, "Basket", 14, 1400));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-business").accept(MediaType.APPLICATION_JSON);
		String expected = "{\"id\": 1,\"name\":\"Basket\",\"price\":14}";
		;
		// MvcResult mvcResult =
		// mockMvc.perform(request).andExpect(content().json(expected))
//				
//				.andReturn();
		MvcResult mvcResult = mockMvc.perform(get("/item-business")).andExpect(status().isOk()).andReturn();

//		System.out.println("Expected result" + mvcResult.getResponse().getContentAsString());
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void All_Items_Test() throws Exception {

		MvcResult mvcResult = mockMvc.perform(get("/items")).andExpect(status().isOk()).andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}

	// test db repo

//	@Test
//	public void test_with_repo() throws Exception {
//		List<Item> list = new ArrayList<Item>();
//		list.add(new Item(1, "basket", 14, 1400));
//		when(itemReposiotory.findAll()).thenReturn(list);
//		System.out.println(ItemBusinessService.getAllItems());
////		MvcResult mvcResult = mockMvc.perform(get("/items")).andExpect(status().isOk()).andReturn();
////		System.out.println(mvcResult.getResponse().getContentAsString());
//	}
}
