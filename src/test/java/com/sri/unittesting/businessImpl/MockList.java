package com.sri.unittesting.businessImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.AnyOf;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

class MockList {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	List mocklist = mock(List.class);

	@Test
	void test() {
		when(mocklist.size()).thenReturn(3).thenReturn(2);
		assertEquals(3, mocklist.size());
		assertEquals(2, mocklist.size());

	}

	@Test
	void Test2() {
		when(mocklist.get(0)).thenReturn("Sri!!");
		assertEquals("Sri!!", mocklist.get(0));
		assertEquals(null, mocklist.get(1));
	}

	@Test
	void Test3() {
		when(mocklist.get(anyInt())).thenReturn("Sri test");
		assertEquals("Sri test", mocklist.get(100));
	}

	@Test
	void Test_verify() {
		when(mocklist.get(anyInt())).thenReturn("Well");
		// called once, so test succeeds
		String value1 = mocklist.get(0).toString();

		verify(mocklist, times(1)).get(anyInt());
	}

	@Test
	void test_verify_1() {
		when(mocklist.get(anyInt())).thenReturn("Hello");

		String value = mocklist.get(0).toString();

		verify(mocklist).get(anyInt());
		verify(mocklist, times(1)).get(anyInt());
	}

	@Test
	void test_arguement_capture() {
		mocklist.add("String...");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> captor2 = ArgumentCaptor.forClass(Integer.class);

		verify(mocklist).add(captor2.capture());

		assertEquals("String...", captor2.getValue());
	}

	@Test
	void test_Spy() {
		ArrayList arrayListMock = mock(ArrayList.class);

		arrayListMock.add("a");
		arrayListMock.add("b");

		arrayListMock.size(); // will return as this is just a mock and this will not actuall instantiate and

		when(arrayListMock.size()).thenReturn(5);
		// now it will return 5

		int size = arrayListMock.size();
//		logger.info(Integer.toString(size));
	}

	@Test
	void test_Spy2() {
		ArrayList arrayListMock = spy(ArrayList.class);

		arrayListMock.add("a");
		arrayListMock.add("b");

		arrayListMock.size(); // will return as this is just a mock and this will not actuall instantiate and

//		when(arrayListMock.size()).thenReturn(5);
		// now it will return 5

		int size = arrayListMock.size();
//		logger.info(Integer.toString(size));
		verify(arrayListMock, times(1)).add("a");
	}
}
