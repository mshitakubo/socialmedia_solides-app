package com.socialmediasolides.usersrv.services;

import com.socialmediasolides.usersrv.entities.Role;
import com.socialmediasolides.usersrv.entities.User;
import com.socialmediasolides.usersrv.models.dtos.UserDto;
import com.socialmediasolides.usersrv.repositories.RoleRepository;
import com.socialmediasolides.usersrv.repositories.UserRepository;
import com.socialmediasolides.usersrv.services.exceptions.EntityNotFoundException;
import com.socialmediasolides.usersrv.services.exceptions.InvalidEmailException;
import com.socialmediasolides.usersrv.util.EmailValidation;
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
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user not found, id: " + id));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("user not found, email: " + email));
    }

    public User create(UserDto userDto) {
        User newUser = new User();
        Role role = new Role();
        List<Role> roleList = new ArrayList<>();
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());

        if (!EmailValidation.isValidEmailAddressRegex(userDto.getEmail())) {
            throw new InvalidEmailException("invalid email format: " + userDto.getEmail());
        }

        if (user.isPresent()) {
            throw new InvalidEmailException("email duplicated: " + userDto.getEmail());
        }

        BeanUtils.copyProperties(userDto, newUser);

        role.setName(userDto.getRoles().get(0).getName());
        roleRepository.save(role);

        roleList.add(role);
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setRoles(roleList);
        return userRepository.save(newUser);
    }
}
