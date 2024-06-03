package com.quest.springbootredis.repository;

import com.quest.springbootredis.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User getUser(Long userId);
}
