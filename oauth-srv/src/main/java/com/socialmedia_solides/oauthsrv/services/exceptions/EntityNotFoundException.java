package com.socialmedia_solides.oauthsrv.services.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EntityNotFoundException extends UsernameNotFoundException {

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
