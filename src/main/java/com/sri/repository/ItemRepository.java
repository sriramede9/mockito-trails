package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
