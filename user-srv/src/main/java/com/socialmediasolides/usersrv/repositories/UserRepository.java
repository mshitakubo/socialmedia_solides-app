package com.socialmediasolides.usersrv.repositories;

import com.socialmediasolides.usersrv.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
