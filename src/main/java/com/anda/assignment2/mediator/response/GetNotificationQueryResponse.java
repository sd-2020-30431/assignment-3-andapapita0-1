package com.anda.assignment2.mediator.response;

import com.anda.assignment2.mediator.Response;
import org.springframework.http.ResponseEntity;

public class GetNotificationQueryResponse implements Response {
    ResponseEntity<String> notification;
    public GetNotificationQueryResponse(ResponseEntity<String> notification){
        this.notification = notification;
    }

    public void setNotification(ResponseEntity<String> notification) {
        this.notification = notification;
    }

    public ResponseEntity<String> getNotification() {
        return notification;
    }
}