package com.example.buddhism_quotes_server.service;

import com.example.buddhism_quotes_server.model.Item;
import com.example.buddhism_quotes_server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        if (item.getId() == null || item.getId().isEmpty()) {
            System.out.println("test....");
            Optional<Item> lastItem = itemRepository.findTopByOrderByIdDesc();
            int nextId = lastItem.map(last -> Integer.parseInt(last.getId()) + 1).orElse(1);

            System.out.println("Result :" + nextId);
            item.setId(String.valueOf(nextId));
        }

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

    public ResponseEntity<String> updateItem(String id, Item newItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setChiDescription(newItem.getChiDescription());
            existingItem.setEngDescription(newItem.getEngDescription());
            itemRepository.save(existingItem);
            return ResponseEntity.ok("Item updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
