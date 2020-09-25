package com.sri.unittest;

import org.springframework.stereotype.Component;

@Component("SomeServiceImpl")
public class SomeServiceImpl implements SomeService {

	@Override
	public int[] getData() {
		// TODO Auto-generated method stub
		return new int[] { 1, 2, 3, 4 };
	}

}
