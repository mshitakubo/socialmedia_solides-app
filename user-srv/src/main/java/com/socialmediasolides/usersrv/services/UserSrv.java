package com.socialmediasolides.usersrv.services;

import com.socialmediasolides.usersrv.entities.User;
import com.socialmediasolides.usersrv.models.dtos.UserDto;
import com.socialmediasolides.usersrv.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSrv {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User create(UserDto userDto) {
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        User save = userRepository.save(newUser);
        return save;
    }
}
