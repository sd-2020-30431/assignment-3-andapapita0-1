package com.anda.assignment2.mediator.response;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Response;

public class AddFoodCommandResponse implements Response {
    private Item item;

    public AddFoodCommandResponse(Item item){
        this.item = item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}

