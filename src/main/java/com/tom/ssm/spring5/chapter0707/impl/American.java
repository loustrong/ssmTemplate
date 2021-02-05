package com.tom.ssm.spring5.chapter0707.impl;

import com.tom.ssm.spring5.chapter0707.Person;

/**
 * @descriptions: American
 * @author: Tom
 * @date: 2021/2/5 下午 07:05
 * @version: 1.0
 */
public class American implements Person {
    @Override
    public String sayHello(String name) {
        return name + ", Hello!";
    }

    @Override
    public String sayGoodBye(String name) {
        return name + ", Good Bye!";
    }
}
