package com.anda.assignment2.controller;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.repositories.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemQueryController extends ItemController {

    public ItemQueryController(ItemRepository itemRepository) {
        super(itemRepository);
    }

    @GetMapping("/groceries")
    public List<Item> getFood() {
        return (List<Item>) itemRepository.findAll();
    }

    @GetMapping("/groceries/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("item not found for " +
                        "this id :: " + id));
        return ResponseEntity.ok().body(item);
    }

    public String getNotificationText(){
        String s = "";
        List<Item> items = (List<Item>) itemRepository.findAll();
        for(Item item : items){
            if(item.oneDayBeforeExpiration())
                s += item.getNotification();
        }
        return s;
    }

    @GetMapping("/notification")
    public ResponseEntity<String> getNotification(){
        String s = "";
        s += '{';
        s += '"';
        s += this.getNotificationText();
        s += '"';
        s += ':';
        s += '"';
        s += "null";
        s += '"';
        s += '}';
        return ResponseEntity.ok().body(s);
    }
}
