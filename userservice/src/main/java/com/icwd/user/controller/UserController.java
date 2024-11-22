package com.icwd.user.controller;

import com.icwd.user.entities.User;
import com.icwd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //save a single user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        String randomUUId = UUID.randomUUID().toString();
        user.setUserId(randomUUId);
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //get a single user
    @GetMapping("/{userId}")
    public  ResponseEntity<User>  getSingleUser(@PathVariable("userId") String userId){
        User user= userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

}
