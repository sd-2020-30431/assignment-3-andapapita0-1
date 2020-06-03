package com.anda.assignment2.controller;

import com.anda.assignment2.mediator.Mediator;
import com.anda.assignment2.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public abstract class ItemController {

    protected final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
