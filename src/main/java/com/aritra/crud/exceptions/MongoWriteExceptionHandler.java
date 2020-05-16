package com.aritra.crud.exceptions;

import com.aritra.crud.controller.util.Message;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MongoWriteExceptionHandler {

    @ExceptionHandler(MongoWriteException.class)
    protected ResponseEntity<Object> handleMongoWriteException() {
        return new ResponseEntity<>(new Message(HttpStatus.BAD_REQUEST,
                "MongoDB write exception due to unique value for license plate"), HttpStatus.BAD_REQUEST);
    }
}
