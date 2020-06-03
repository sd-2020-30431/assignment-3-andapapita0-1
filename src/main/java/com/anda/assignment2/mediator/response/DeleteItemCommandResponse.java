package com.anda.assignment2.mediator.response;

import com.anda.assignment2.mediator.Response;

import java.util.Map;

public class DeleteItemCommandResponse implements Response{
    private Map<String, Boolean> map;

    public DeleteItemCommandResponse(Map<String, Boolean> map){
        this.map = map;
    }

    public void setMap(Map<String, Boolean> map) {
        this.map = map;
    }

    public Map<String, Boolean> getMap() {
        return map;
    }
}
