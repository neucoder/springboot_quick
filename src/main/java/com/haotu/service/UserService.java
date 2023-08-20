package com.haotu.service;

import com.haotu.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> list();
}
