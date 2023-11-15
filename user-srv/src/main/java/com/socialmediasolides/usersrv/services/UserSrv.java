package com.socialmediasolides.usersrv.services;

import com.socialmediasolides.usersrv.entities.Role;
import com.socialmediasolides.usersrv.entities.User;
import com.socialmediasolides.usersrv.models.dtos.UserDto;
import com.socialmediasolides.usersrv.repositories.UserRepository;
import com.socialmediasolides.usersrv.repositories.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSrv {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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
        Role role = new Role();
        List<Role> roleList = new ArrayList<>();

        BeanUtils.copyProperties(userDto, newUser);

        role.setName(userDto.getRoles().get(0).getName());
        roleRepository.save(role);


        System.out.println(role);
        roleList.add(role);
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setRoles(roleList);
        User save = userRepository.save(newUser);
        return save;
    }
}
