package com.company.service;

import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(UserEntity user){
        userRepository.save(user);
    }

    public List<UserEntity> findAllByFirstName(String name){
        return userRepository.findAllByFirstName(name);
    }
}
