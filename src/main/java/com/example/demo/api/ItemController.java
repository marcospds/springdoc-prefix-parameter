package com.example.demo.api;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.ItemRepository;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

	private ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping
	public Slice<Item> getAll(@ParameterObject Pageable pageable) {
		return itemRepository.findAll(pageable);
	}
}
