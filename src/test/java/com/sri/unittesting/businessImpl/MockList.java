package com.sri.unittesting.businessImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.AnyOf;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

class MockList {

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
}
