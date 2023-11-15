package com.socialmedia_solides.postssrv.services.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException(String msg) {
        super(msg);
    }
}

