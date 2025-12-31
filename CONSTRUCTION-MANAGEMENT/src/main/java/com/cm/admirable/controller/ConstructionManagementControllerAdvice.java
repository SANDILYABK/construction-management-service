package com.cm.admirable.controller;

import com.cm.admirable.dto.LoginResponse;
import com.cm.admirable.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ConstructionManagementControllerAdvice {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public void handleException() {

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<LoginResponse> handleUserNotFoundException() {
        return ResponseEntity.status(404).body(new LoginResponse("FAILED", "User Not found."));
    }

}
