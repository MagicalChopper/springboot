package com.coder.service;

import com.coder.entity.User;

public interface UserService {
    User findUserByName(String name);
}
