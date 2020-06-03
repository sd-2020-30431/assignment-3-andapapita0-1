package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.controller.ItemCommandController;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.UpdateItemCommand;
import com.anda.assignment2.mediator.response.UpdateItemCommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateItemCommandHandler implements Handler<UpdateItemCommand, UpdateItemCommandResponse> {

    private final ItemCommandController itemCommandController;

    @Autowired
    public UpdateItemCommandHandler(ItemCommandController itemCommandController) {
        this.itemCommandController = itemCommandController;
    }


    @Override
    public UpdateItemCommandResponse handle(UpdateItemCommand q) throws ResourceNotFoundException {
        return new UpdateItemCommandResponse(itemCommandController.updateItem(
                q.getId(), q.getItem()
        ));
    }
}
