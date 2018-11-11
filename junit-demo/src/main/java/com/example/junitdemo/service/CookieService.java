package com.example.junitdemo.service;

import com.example.junitdemo.service.dto.Cookie;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CookieService {

    public List<Cookie> getCoookies() {
        return Collections.singletonList(new Cookie() {
            {
                setName("shortbread");
            }
        });
    }
}
