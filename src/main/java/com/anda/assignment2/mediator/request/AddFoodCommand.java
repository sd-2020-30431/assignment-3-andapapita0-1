package com.anda.assignment2.mediator.request;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Request;

public class AddFoodCommand implements Request {
    private Item item;

    public AddFoodCommand(Item item){
        this.item = item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
