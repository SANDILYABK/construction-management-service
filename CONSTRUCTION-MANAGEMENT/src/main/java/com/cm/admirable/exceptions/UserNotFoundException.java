package com.cm.admirable.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String unf){
        super(unf);
    }
}
