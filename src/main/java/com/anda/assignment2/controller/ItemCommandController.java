package com.anda.assignment2.controller;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.repositories.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemCommandController extends ItemController{

    public ItemCommandController(ItemRepository itemRepository) {
        super(itemRepository);
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
        tableItem.setConsumptionDate(item.getConsumptionDate());
        final Item updatedItem = itemRepository.save(tableItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/groceries/delete/{id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Item tableItem = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found " + id));
        itemRepository.delete(tableItem);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
