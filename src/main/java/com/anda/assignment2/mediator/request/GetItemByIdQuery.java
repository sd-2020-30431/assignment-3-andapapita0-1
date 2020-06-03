package com.anda.assignment2.mediator.request;

import com.anda.assignment2.mediator.Request;
import com.anda.assignment2.mediator.Response;

public class GetItemByIdQuery implements Request {
    private Long id;

    public GetItemByIdQuery(Long id){
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
