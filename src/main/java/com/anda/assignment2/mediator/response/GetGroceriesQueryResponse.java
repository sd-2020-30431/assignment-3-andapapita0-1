package com.anda.assignment2.mediator.response;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.mediator.Response;

import java.util.List;

public class GetGroceriesQueryResponse implements Response {
    private List<Item> groceries;

    public GetGroceriesQueryResponse(List<Item> groceries){
        this.groceries = groceries;
    }

    public void setGroceries(List<Item> groceries) {
        this.groceries = groceries;
    }

    public List<Item> getGroceries() {
        return groceries;
    }
}
