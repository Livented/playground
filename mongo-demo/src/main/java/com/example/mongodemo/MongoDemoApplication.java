package com.example.mongodemo;

import com.example.mongodemo.repository.ItemRepository;
import com.example.mongodemo.repository.ItemTypeRepository;
import com.example.mongodemo.repository.dto.Item;
import com.example.mongodemo.repository.dto.ItemType;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class MongoDemoApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MongoDemoApplication.class);

    private final MongoTemplate mongoTemplate;
    private final ItemRepository itemRepository;
    private final ItemTypeRepository itemTypeRepository;

    public MongoDemoApplication(MongoTemplate mongoTemplate, ItemRepository itemRepository, ItemTypeRepository itemTypeRepository) {
        this.mongoTemplate = mongoTemplate;
        this.itemRepository = itemRepository;
        this.itemTypeRepository = itemTypeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        if (mongoTemplate.collectionExists(Item.class)) {
            LOG.info("Collection already exist");
            return;
        }

        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = false;

        for (int i = 1; i < 10; i++) {
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

            ItemType itemType = new ItemType();
            itemType.setId(i);
            itemType.setName(generatedString);
            itemTypeRepository.save(itemType);
        }

        int min = 1;
        int max = 10;

        for (int i = 1; i < 55000; i++) {
            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            int randomNum = ThreadLocalRandom.current().nextInt(min, max);

            Item item = new Item();
            item.setId(i);
            ItemType itemType = new ItemType();
            itemType.setId(randomNum);
            item.setType(itemType);
            item.setName(generatedString);
            itemRepository.save(item);
        }
    }
}
