package com.example.mongodemo.repository;

import com.example.mongodemo.repository.dto.ItemNoDbRef;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemNoDbRefRepository extends MongoRepository<ItemNoDbRef, Integer> {

    @Override
    @Query(value = "{}", fields = "{'_id': 1, 'name': 1, 'type.$id': 1}")
    List<ItemNoDbRef> findAll();

    @Override
    @Query(value = "{}", fields = "{'_id': 1, 'name': 1, 'type.$id': 1}")
    Page<ItemNoDbRef> findAll(Pageable pageable);

    @Query(value = "{'_id': ?0}", fields = "{'_id': 1, 'name': 1, 'type.$id': 1}")
    ItemNoDbRef findById(int id);
}
