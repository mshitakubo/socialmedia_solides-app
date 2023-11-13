package com.socialmedia_solides.oauthsrv.services.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
