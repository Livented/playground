package com.example.junitdemo;

import com.example.junitdemo.service.CookieService;
import com.example.junitdemo.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitDemoApplicationTests {

    @TestConfiguration
    static class TestContextConfiguration {

        @Bean
        public ItemService itemService() {
            return new ItemService();
        }

        @Bean
        public CookieService cookieService() {
            return new CookieService();
        }
    }

    @Autowired
    private ItemService itemService;

    @Autowired
    private CookieService cookieService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getItemsTest() {
        itemService.getItems();
    }

    @Test
    public void getCookiesTest() {
        cookieService.getCoookies();
    }
}
