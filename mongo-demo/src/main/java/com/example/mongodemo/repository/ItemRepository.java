package com.example.mongodemo.repository;

import com.example.mongodemo.repository.dto.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, Integer> {
}
