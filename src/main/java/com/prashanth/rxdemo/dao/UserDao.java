package com.prashanth.rxdemo.dao;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.prashanth.rxdemo.model.User;

import reactor.core.publisher.Flux;

@Component
public class UserDao {

    public List<User> getUsers() {
        return IntStream.range(0, 10)
                .peek(value -> {
                    try {
                        System.out.println("Processing user " + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .mapToObj(i -> {
                    User user = new User();
                    user.setUsername("user" + i);
                    user.setEmail("user" + i + "@gmail.com");
                    return user;
                })
                .toList();
    }

    public Flux<User> getFluxUsers() {
        return Flux.range(0, 10)
                .doOnNext(value -> {
                    try {
                        System.out.println("Processing flux user " + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .map(i -> {
                    User user = new User();
                    user.setUsername("user" + i);
                    user.setEmail("user" + i + "@gmail.com");
                    return user;
                });
    }
}
