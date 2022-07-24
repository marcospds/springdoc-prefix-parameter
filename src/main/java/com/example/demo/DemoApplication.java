package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Item;
import com.example.demo.model.ItemRepository;

@SpringBootApplication
public class DemoApplication {

	private ItemRepository itemRepository;

	public DemoApplication(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	private void init() {
		for(Integer i = 0;i < 50;i++) {
			itemRepository.save(new Item(String.valueOf(i)));
		}
	}
}
