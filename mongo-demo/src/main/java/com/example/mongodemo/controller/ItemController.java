package com.example.mongodemo.controller;

import com.example.mongodemo.repository.ItemNoDbRefRepository;
import com.example.mongodemo.repository.ItemRepository;
import com.example.mongodemo.repository.dto.Item;
import com.example.mongodemo.repository.dto.ItemNoDbRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemNoDbRefRepository itemNoDbRefRepository;

    @GetMapping
    public Page<Item> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @GetMapping("/testWithoutGetName")
    public ResponseEntity<?> testWithoutGetName() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.getId();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testWithGetName")
    public ResponseEntity<?> testWithGetName() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.getType().getName();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testWithGetId")
    public ResponseEntity<?> testWithGetId() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.getType().getId();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testNoDbRef/{id}")
    public ResponseEntity<?> testNoDbRef(@PathVariable Integer id) {
        ItemNoDbRef item = itemNoDbRefRepository.findById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/testNoDbRef/all")
    public Page<ItemNoDbRef> getItemsNoDbRef(Pageable pageable) {
        return itemNoDbRefRepository.findAll(pageable);
    }

    @GetMapping("/testNoDbRef/allGetTypeId")
    public ResponseEntity<?> getItemsNoDbRef() {
        List<ItemNoDbRef> items = itemNoDbRefRepository.findAll();
        boolean once = true;
        for (ItemNoDbRef item : items) {
            item.getTypeId();
            if (once) {
                LOG.info(item.getTypeId().toString());
                once = false;
            }
        }
        return ResponseEntity.ok().build();
    }
}
