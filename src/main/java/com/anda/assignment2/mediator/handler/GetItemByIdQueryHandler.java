package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.controller.ItemQueryController;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.GetGroceriesQuery;
import com.anda.assignment2.mediator.request.GetItemByIdQuery;
import com.anda.assignment2.mediator.response.GetGroceriesQueryResponse;
import com.anda.assignment2.mediator.response.GetItemByIdQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetItemByIdQueryHandler implements Handler<GetItemByIdQuery, GetItemByIdQueryResponse> {
    private final ItemQueryController itemQueryController;

    @Autowired
    public GetItemByIdQueryHandler(ItemQueryController itemQueryController) {
        this.itemQueryController = itemQueryController;
    }

    @Override
    public GetItemByIdQueryResponse handle(GetItemByIdQuery q) throws ResourceNotFoundException {
        ResponseEntity<Item> item = itemQueryController.getItemById(q.getId());
        return new GetItemByIdQueryResponse(item);
    }

}
