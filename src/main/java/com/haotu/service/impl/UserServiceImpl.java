package com.haotu.service.impl;

import com.haotu.dao.UserRepository;
import com.haotu.entity.User;
import com.haotu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user service impl
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepository userDao;


    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}
