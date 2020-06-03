package com.anda.assignment2.mediator.request;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Request;

public class UpdateItemCommand implements Request {
    Long id;
    Item item;
    public UpdateItemCommand(Long id, Item item){
        this.id=id;
        this.item = item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
