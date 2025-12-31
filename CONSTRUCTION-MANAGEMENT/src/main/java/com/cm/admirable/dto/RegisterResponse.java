package com.cm.admirable.dto;

public record RegisterResponse(String message) {
    public RegisterResponse() {
        this("User registered successfully & verification email sent.");
    }
}
