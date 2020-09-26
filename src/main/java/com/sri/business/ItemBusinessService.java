package com.sri.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sri.model.Item;
import com.sri.repository.ItemRepository;

@Component("ItemBusinessService")
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;

//	public void setItemRepository(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}

	public Item getHardCodedItem() {
		// TODO Auto-generated method stub
		return new Item("Basket", 14, 1400);
	}

	public Item saveItem(Item item) {
		Item savedItem = itemRepository.save(item);
		return savedItem;
	}

	public Item getItemById(int id) {
		return itemRepository.findById(id).get();
	}

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

}
