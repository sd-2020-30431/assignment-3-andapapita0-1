package com.anda.assignment2.mediator.response;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Response;
import com.anda.assignment2.mediator.request.UpdateItemCommand;
import org.springframework.http.ResponseEntity;

public class UpdateItemCommandResponse implements Response {
    private ResponseEntity<Item> item;

    public UpdateItemCommandResponse(ResponseEntity<Item> item){
        this.item = item;
    }

    public void setItem(ResponseEntity<Item> item) {
        this.item = item;
    }

    public ResponseEntity<Item> getItem() {
        return item;
    }
}
