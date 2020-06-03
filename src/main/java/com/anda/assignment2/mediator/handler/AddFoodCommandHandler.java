package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.controller.ItemCommandController;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.AddFoodCommand;
import com.anda.assignment2.mediator.response.AddFoodCommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddFoodCommandHandler implements Handler<AddFoodCommand, AddFoodCommandResponse> {

    private final ItemCommandController itemCommandController;

    @Autowired
    public AddFoodCommandHandler(ItemCommandController itemCommandController) {
        this.itemCommandController = itemCommandController;
    }
    @Override
    public AddFoodCommandResponse handle(AddFoodCommand q) {
        return new AddFoodCommandResponse(itemCommandController.addFood(q.getItem()));
    }
}
