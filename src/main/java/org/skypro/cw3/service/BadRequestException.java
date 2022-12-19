package org.skypro.cw3.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ResponseStatusException {

    public BadRequestException(HttpStatusCode status) {
        super(status);
    }

    public BadRequestException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
