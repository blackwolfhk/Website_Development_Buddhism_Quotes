package com.example.buddhism_quotes_server.repository;

import com.example.buddhism_quotes_server.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
