package com.tom.ssm.spring5.chapter0805.simpleCache.service.impl;

import com.tom.ssm.spring5.chapter0805.simpleCache.domain.User;
import com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


/**
 * @descriptions: UserServiceImpl
 * @author: Tom
 * @date: 2021/2/10 下午 04:00
 * @version: 1.0
 */
@Service("userService")
@Cacheable(value="users", key = "#name",condition = "#age < 1000")
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(value = "users1")
    public User getUsersByNameAndAge(String name, int age) {
        System.out.println("--is execute one method.--");
        return new User(name, age);
    }

    @Override
    @Cacheable(value = "users2")
    public User getAnotherUser(String name, int age) {
        System.out.println("--is execute another method.--");
        return new User(name, age);
    }
    @Override
    @CacheEvict(value = "users")
    public void evictUser(String name,int age){
        System.out.println("正在清空" + name + ", " + age + "对应的缓存---");
    }
    @CacheEvict(value = "users", allEntries = true)
    public void evictAll(){
        System.out.println("--正在清空整个缓存---");
    }
}
