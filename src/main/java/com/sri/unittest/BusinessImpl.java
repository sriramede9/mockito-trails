package com.sri.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessImpl {

	@Autowired
	@Qualifier("SomeServiceImpl")
	private SomeService someService;

	public void setSomeService(SomeService someService) {
		this.someService = someService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;

		for (int i : data) {
			sum = sum + i;
		}
		return sum;
	}

	@GetMapping("/test")
	public int calculateSumFromService() {
		int[] data = someService.getData();
		int sum = 0;

		for (int i : data) {
			sum = sum + i;
		}
		return sum;
	}
}
