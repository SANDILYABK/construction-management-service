package com.cm.admirable.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String email){
        super("Email Already Exist"+ email);
    }
}
