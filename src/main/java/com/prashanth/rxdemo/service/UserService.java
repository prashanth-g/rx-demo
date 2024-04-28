package com.prashanth.rxdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanth.rxdemo.dao.UserDao;
import com.prashanth.rxdemo.model.User;

import reactor.core.publisher.Flux;

@Service
public class UserService {
   
    @Autowired
    UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public Flux<User> getFluxUsers() {
        return userDao.getFluxUsers();
    }
}
