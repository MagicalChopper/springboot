package com.coder.service;

import com.coder.entity.User;

import java.util.List;

public interface UserService {
//    User findUserByName(String name);

    void createUser(User user);


    void deleteUser(long id);

    void updateUser(User user);

    User retrieveOne(long id);

    List<User> retrieveAll();
}
