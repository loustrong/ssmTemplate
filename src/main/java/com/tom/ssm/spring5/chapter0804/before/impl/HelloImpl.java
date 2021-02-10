package com.tom.ssm.spring5.chapter0804.before.impl;

import com.tom.ssm.spring5.chapter0804.before.Hello;
import org.springframework.stereotype.Component;

/**
 * @descriptions: HelloImpl
 * @author: Tom
 * @date: 2021/2/10 下午 01:51
 * @version: 1.0
 */
@Component("hello")
public class HelloImpl implements Hello {

    @Override
    public void deleteUser(Integer id) {
        if(id < 0){
            throw new IllegalArgumentException("被刪除用戶的id不能小於0:" +id);
        }
        System.out.println("~~~before0804~~~execute hello delete mwthod.");
    }

    @Override
    public int addUser(String name, String pass) {
        System.out.println("~~~before0804~~~execute hello add method.");
        return 20;
    }
}
