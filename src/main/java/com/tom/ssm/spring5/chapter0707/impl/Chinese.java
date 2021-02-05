package com.tom.ssm.spring5.chapter0707.impl;

import com.tom.ssm.spring5.chapter0707.Person;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/5 下午 07:07
 * @version: 1.0
 */
public class Chinese implements Person {
    @Override
    public String sayHello(String name) {
        return name + ", 您好!";
    }

    @Override
    public String sayGoodBye(String name) {
        return name + ", 下次再見!";
    }
}
