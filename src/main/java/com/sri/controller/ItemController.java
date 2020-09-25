package com.sri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.Item;

@RestController
public class ItemController {

	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "Basket", 10, 100);
	}
}
