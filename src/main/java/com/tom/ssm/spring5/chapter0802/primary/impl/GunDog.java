package com.tom.ssm.spring5.chapter0802.primary.impl;

import com.tom.ssm.spring5.chapter0802.primary.Dog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @descriptions: GunDog
 * @author: Tom
 * @date: 2021/2/8 下午 08:14
 * @version: 1.0
 */
@Component
public class GunDog implements Dog {

    @Value("wangcai")
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String run() {
        return "This is a dog, his name is "
                + this.getName() + ".";
    }
}
