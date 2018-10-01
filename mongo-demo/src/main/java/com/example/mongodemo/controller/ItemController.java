package com.example.mongodemo.controller;

import com.example.mongodemo.repository.ItemRepository;
import com.example.mongodemo.repository.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public Page<Item> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
}