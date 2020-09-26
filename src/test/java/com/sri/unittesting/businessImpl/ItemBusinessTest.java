package com.sri.unittesting.businessImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sri.business.ItemBusinessService;
import com.sri.model.Item;
import com.sri.repository.ItemRepository;
import com.sri.unittest.BusinessImpl;
import com.sri.unittest.SomeService;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessTest {

//	@InjectMocks
//	BusinessImpl businessImpl = new BusinessImpl();

	@InjectMocks
	private ItemBusinessService itemBusinessServie = new ItemBusinessService();

	// service Inteface as Mock

	@Mock
	private ItemRepository itemRepository;

//	@Mock
//	SomeService someServiceMock;

	@Test
	public void mockSomeService_sum_with_data_test() {

//		when(someServiceMock.getData()).thenReturn(new int[] { 1, 2, 3, 4 });

		List<Item> value = new ArrayList<Item>();
		value.add(new Item(1, "t", 1, 1));

		when(itemRepository.findAll()).thenReturn(value);

//		businessImpl.setSomeService(someServiceMock);

		System.out.println(itemRepository.findAll().size());

//		assertEquals(10, businessImpl.calculateSumFromService());

	}
}
