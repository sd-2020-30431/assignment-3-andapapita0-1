package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.controller.ItemQueryController;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.GetGroceriesQuery;
import com.anda.assignment2.mediator.response.GetGroceriesQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetGroceriesQueryHandler implements Handler<GetGroceriesQuery, GetGroceriesQueryResponse> {

    private final ItemQueryController itemQueryController;

    @Autowired
    public GetGroceriesQueryHandler(ItemQueryController itemQueryController) {
        this.itemQueryController = itemQueryController;
    }

    @Override
    public GetGroceriesQueryResponse handle(GetGroceriesQuery q) {
        List<Item> groceries = itemQueryController.getFood();
        return new GetGroceriesQueryResponse(groceries);
    }
}
