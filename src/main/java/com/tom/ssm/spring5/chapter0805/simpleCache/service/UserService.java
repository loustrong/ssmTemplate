package com.tom.ssm.spring5.chapter0805.simpleCache.service;

import com.tom.ssm.spring5.chapter0805.simpleCache.domain.User;

public interface UserService {
    User getUsersByNameAndAge(String name, int age);
    User getAnotherUser(String name, int age);
}
