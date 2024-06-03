package com.quest.springbootredis.service;

import com.quest.springbootredis.model.User;
import com.quest.springbootredis.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userDao.fetchAllUsers();
    }

    @Override
    public User getUser(Long userId) {
        return userDao.getUser(userId);
    }
}
