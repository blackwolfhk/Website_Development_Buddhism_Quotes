package com.example.buddhism_quotes_server.repository;

import com.example.buddhism_quotes_server.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    @Query(value = "{}", sort = "{ id : -1 }")
    Optional<Item> findTopByOrderByIdDesc();
}
