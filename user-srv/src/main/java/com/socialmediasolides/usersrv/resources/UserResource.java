package com.socialmediasolides.usersrv.resources;

import com.socialmediasolides.usersrv.entities.User;
import com.socialmediasolides.usersrv.services.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserSrv userSrv;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userSrv.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userSrv.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
