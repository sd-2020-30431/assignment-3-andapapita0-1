package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.controller.ItemCommandController;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.DeleteItemCommand;
import com.anda.assignment2.mediator.response.DeleteItemCommandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteItemCommandHandler implements Handler<DeleteItemCommand, DeleteItemCommandResponse> {

    private final ItemCommandController itemCommandController;

    @Autowired
    public DeleteItemCommandHandler(ItemCommandController itemCommandController) {
        this.itemCommandController = itemCommandController;
    }

    @Override
    public DeleteItemCommandResponse handle(DeleteItemCommand q) throws ResourceNotFoundException {
        return new DeleteItemCommandResponse(itemCommandController.deleteItem(q.getId()));
    }
}
