package com.tom.ssm.spring5.chapter0802.primary.impl;

import com.tom.ssm.spring5.chapter0802.primary.Dog;
import com.tom.ssm.spring5.chapter0802.primary.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/8 下午 08:18
 * @version: 1.0
 */
@Component
public class Chinese implements Person {
    private Dog dog;
    @Autowired
    public void setDog(Dog dog){
        this.dog = dog;
    }

    @Override
    public void test() {

    }
}
