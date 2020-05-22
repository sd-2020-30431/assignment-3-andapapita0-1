package com.anda.assignment2.controller;

import com.anda.assignment2.bean.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/groceries")
    public List<Item> getFood() {
        return (List<Item>) itemRepository.findAll();
    }

    @PostMapping("/groceries")
    void addFood(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @PostMapping("/groceries/{id}")
    public ResponseEntity<Item> updateItem (@PathVariable(value = "id") Long id,
                                            @RequestBody Item item) throws ResourceNotFoundException {
        Item tableItem = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found " + id));
        tableItem.setName(item.getName());
        tableItem.setQuantity(item.getQuantity());
        //more ??
        tableItem.setConsumptionDate(item.getConsumptionDate());
        final Item updatedItem = itemRepository.save(tableItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/groceries/{id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Item tableItem = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found " + id));
        itemRepository.delete(tableItem);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
