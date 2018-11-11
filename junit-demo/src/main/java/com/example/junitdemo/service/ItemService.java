package com.example.junitdemo.service;

import com.example.junitdemo.service.dto.Item;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ItemService {

    public List<Item> getItems() {
        return Collections.singletonList(new Item() {
            {
                setId(1);
            }
        });
    }
}
