package com.anda.assignment2.mediator.request;

import com.anda.assignment2.mediator.Request;

public class DeleteItemCommand implements Request {
    private Long id;

    public DeleteItemCommand(Long id){
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
