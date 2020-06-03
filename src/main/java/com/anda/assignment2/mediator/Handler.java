package com.anda.assignment2.mediator;

import com.anda.assignment2.exception.ResourceNotFoundException;

public interface Handler<Request, Response> {
    Response handle(Request q) throws ResourceNotFoundException;
}
