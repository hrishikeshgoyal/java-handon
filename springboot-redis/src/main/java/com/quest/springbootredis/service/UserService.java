package com.quest.springbootredis.service;

import com.quest.springbootredis.model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User getUser(Long userId);
}
