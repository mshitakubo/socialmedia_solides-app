package com.socialmedia_solides.oauthsrv.services;

import com.socialmedia_solides.oauthsrv.entities.User;
import com.socialmedia_solides.oauthsrv.feignclients.UserFeignClients;
import com.socialmedia_solides.oauthsrv.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSrv {

    @Autowired
    private UserFeignClients feignClients;

    public User findByEmail(String email) {
        User user = feignClients.findByEmail(email).getBody();
        if (user == null) {
            throw new EntityNotFoundException("Email not found");
        }
        return user;
    }
}
