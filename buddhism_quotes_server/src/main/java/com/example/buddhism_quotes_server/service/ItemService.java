package com.example.buddhism_quotes_server.service;

import com.example.buddhism_quotes_server.model.Item;
import com.example.buddhism_quotes_server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public ResponseEntity<String> saveItem(Item item) {
        Optional<Item> existingItem = itemRepository.findById(item.getId());
        if (existingItem.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Item with ID " + item.getId() + " already exists");
        } else {
            itemRepository.save(item);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Item saved successfully");
        }
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
