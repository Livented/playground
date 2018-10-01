package com.example.mongodemo.repository.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itemType")
public class ItemType {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
