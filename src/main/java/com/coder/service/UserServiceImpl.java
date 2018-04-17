package com.coder.service;

import com.coder.dao.UserDao;
import com.coder.dao.UserRepository;
import com.coder.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public void createUser(User user) {
         userDao.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.remove(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public User retrieveOne(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> retrieveAll() {
        return userDao.getUserList();
    }
}
