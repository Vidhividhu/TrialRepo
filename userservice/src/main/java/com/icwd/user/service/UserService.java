package com.icwd.user.service;

import com.icwd.user.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //create user
    User saveUser(User user);

    //get all users
    List<User> getAllUser();

    //get single user of given userId
    User getUser(String userId);

}
