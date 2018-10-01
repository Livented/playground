package com.example.mongodemo.repository;

import com.example.mongodemo.repository.dto.ItemType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemTypeRepository extends MongoRepository<ItemType, Integer> {
}
