package com.anda.assignment2.mediator.response;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Response;
import org.springframework.http.ResponseEntity;

public class GetItemByIdQueryResponse implements Response {
    private ResponseEntity<Item> item;
    public GetItemByIdQueryResponse(ResponseEntity<Item> item){
            this.item = item;
    }

    public void setItem(ResponseEntity<Item> item) {
        this.item = item;
    }

    public ResponseEntity<Item> getItem() {
        return item;
    }
}
