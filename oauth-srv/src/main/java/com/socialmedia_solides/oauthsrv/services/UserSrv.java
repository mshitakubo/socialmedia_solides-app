package com.socialmedia_solides.oauthsrv.services;

import com.socialmedia_solides.oauthsrv.entities.User;
import com.socialmedia_solides.oauthsrv.feignclients.UserFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSrv implements UserDetailsService {

    @Autowired
    private UserFeignClients feignClients;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = feignClients.findByEmail(userName).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        return user;
    }
}
