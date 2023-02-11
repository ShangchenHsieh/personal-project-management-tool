package com.shangchenhsieh.udemyCoursePPMT.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameAlreadyExistedException extends RuntimeException {

    public UsernameAlreadyExistedException(String message) {
        super(message);
    }
}
