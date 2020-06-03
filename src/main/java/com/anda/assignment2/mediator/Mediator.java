package com.anda.assignment2.mediator;


import com.anda.assignment2.mediator.handler.*;
import com.anda.assignment2.mediator.request.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<Class<? extends Request>, Class<? extends Handler<? extends Request, ? extends Response>>> handlerMap;

    public Mediator(){
        handlerMap = new HashMap<>();
        handlerMap.put(GetGroceriesQuery.class, GetGroceriesQueryHandler.class);
        handlerMap.put(AddFoodCommand.class, AddFoodCommandHandler.class);
        handlerMap.put(DeleteItemCommand.class, DeleteItemCommandHandler.class);
        handlerMap.put(GetItemByIdQuery.class, GetItemByIdQueryHandler.class);
        handlerMap.put(GetNotificationQuery.class, GetNotificationQueryHandler.class);
        handlerMap.put(UpdateItemCommand.class, UpdateItemCommandHandler.class);
    }

    public <T extends Request, R extends Response> Handler<T, R> getHandler(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMap.get(request.getClass());
        return (Handler<T, R>) applicationContext.getBean(handlerType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
