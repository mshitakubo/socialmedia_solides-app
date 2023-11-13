package com.socialmedia_solides.oauthsrv.feignclients;

import com.socialmedia_solides.oauthsrv.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "user-srv", path = "/users")
public interface UserFeignClients {

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);

}
