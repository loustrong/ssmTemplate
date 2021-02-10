package com.tom.ssm.spring5.chapter0805.simpleCache.service.impl;

import com.tom.ssm.spring5.chapter0805.simpleCache.domain.User;
import com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


/**
 * @descriptions: UserServiceImpl
 * @author: Tom
 * @date: 2021/2/10 下午 04:00
 * @version: 1.0
 */
@Service("userService")
@Cacheable(value="users")
public class UserServiceImpl implements UserService {
    @Override
    public User getUsersByNameAndAge(String name, int age) {
        System.out.println("--is execute one method.--");
        return new User(name, age);
    }

    @Override
    public User getAnotherUser(String name, int age) {
        System.out.println("--is execute another method.--");
        return new User(name, age);
    }
}
