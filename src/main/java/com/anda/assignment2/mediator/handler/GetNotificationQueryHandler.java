package com.anda.assignment2.mediator.handler;

import com.anda.assignment2.controller.ItemQueryController;
import com.anda.assignment2.exception.ResourceNotFoundException;
import com.anda.assignment2.mediator.Handler;
import com.anda.assignment2.mediator.request.GetNotificationQuery;
import com.anda.assignment2.mediator.response.GetNotificationQueryResponse;

public class GetNotificationQueryHandler implements
        Handler<GetNotificationQuery, GetNotificationQueryResponse> {

    private final ItemQueryController itemQueryController;

    public GetNotificationQueryHandler(ItemQueryController itemQueryController) {
        this.itemQueryController = itemQueryController;
    }


    @Override
    public GetNotificationQueryResponse handle(GetNotificationQuery q) throws ResourceNotFoundException {
        return new GetNotificationQueryResponse(itemQueryController.getNotification());
    }
}
