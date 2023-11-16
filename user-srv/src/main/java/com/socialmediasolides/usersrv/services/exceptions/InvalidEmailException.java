package com.socialmediasolides.usersrv.services.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String msg){
        super(msg);
    }
}
