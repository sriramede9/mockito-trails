package com.sri.unittesting.businessImpl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sri.unittest.BusinessImpl;
import com.sri.unittest.SomeService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessImplTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// class in which we are seeting this
	@InjectMocks
	BusinessImpl businessImpl = new BusinessImpl();

	// service Inteface as Mock
	@Mock
	SomeService someServiceMock;

//	SomeService someServiceMock = mock(SomeService.class);

//	@Before
//	public void before() {
//		logger.info("Before Each Class....");
//		businessImpl.setSomeService(someServiceMock);
//	}

//	@Test
//	public void Calculate_Sum() {
//		BusinessImpl businessImpl = new BusinessImpl();
//		int[] sample = new int[] { 1, 2, 3, 4 };
//
//		assertEquals(10, businessImpl.calculateSum(sample));
//	}
//
//	@Test
//	public void Calculate_Sum_with_inteface() {
//
//		BusinessImpl businessImpl = new BusinessImpl();
//		businessImpl.setSomeService(new SomeServiceImplTest());
//
////		int[] sample = new int[] { 1, 2, 3, 4 };
//
//		assertEquals(15, businessImpl.calculateSumFromService());
//	}

	@Test
	public void mockSomeService_sum_with_data_test() {

		when(someServiceMock.getData()).thenReturn(new int[] { 1, 2, 3, 4 });

//		businessImpl.setSomeService(someServiceMock);

		assertEquals(10, businessImpl.calculateSumFromService());

	}

}
