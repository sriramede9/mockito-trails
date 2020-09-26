package com.sri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.business.ItemBusinessService;
import com.sri.model.Item;

@RestController
public class ItemController {

	@Autowired
	ItemBusinessService ItemBusinessService;

	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "Basket", 10, 100);
	}

	@GetMapping("/item-business")
	public Item getItembusiness() {
		return ItemBusinessService.getHardCodedItem();
	}

	@GetMapping("/item/{id}")
	public Item getItembyId(@PathVariable("id") int id) {
		return ItemBusinessService.getItemById(id);
	}

	@PostMapping("/item")
	public Item addItem(@RequestBody Item item) {
		return ItemBusinessService.saveItem(item);
	}

	@GetMapping("/sample")
	public Item createSampleItem() {
		return ItemBusinessService.saveItem(new Item(1, "basket", 10, 100));
	}

	@GetMapping("/items")
	public List<Item> getAllItems() {
		List<Item> items = ItemBusinessService.getAllItems();

		for (Item i : items) {
			i.setValue(i.getQuantity() * i.getPrice());
		}
		return items;
	}
}
