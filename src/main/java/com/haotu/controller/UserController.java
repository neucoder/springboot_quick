package com.haotu.controller;

import com.haotu.entity.User;
import com.haotu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public User add(User user) {
        for (User user1 : userService.list()) {
            if (user1.getUserId() == user.getUserId()) {
                return user1;
            }

        }
        userService.addUser(user);
        return user;
    }

    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
