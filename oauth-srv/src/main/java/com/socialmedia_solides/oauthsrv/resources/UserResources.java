package com.socialmedia_solides.oauthsrv.resources;

import com.socialmedia_solides.oauthsrv.services.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResources {

    @Autowired
    private UserSrv userSrv;

    @GetMapping("/search")
    public ResponseEntity<UserDetails> findByEmail(@RequestParam String email) {
        UserDetails userDetails = userSrv.loadUserByUsername(email);
        return ResponseEntity.ok(userDetails);
    }

}
