package com.example.junitdemo.controller;

import com.example.junitdemo.service.CookieService;
import com.example.junitdemo.service.ItemService;
import com.example.junitdemo.service.dto.Cookie;
import com.example.junitdemo.service.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private CookieService cookieService;

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/cookies")
    public List<Cookie> getCookies() {
        return cookieService.getCoookies();
    }
}
