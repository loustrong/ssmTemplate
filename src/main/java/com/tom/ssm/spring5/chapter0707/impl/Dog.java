package com.tom.ssm.spring5.chapter0707.impl;

import com.tom.ssm.spring5.chapter0707.Being;

/**
 * @descriptions: Dog
 * @author: Tom
 * @date: 2021/2/5 下午 06:53
 * @version: 1.0
 */
public class Dog implements Being {
    private String msg;
    public void setMsg(String msg){
        this.msg = msg;
    }
    @Override
    public void testBeing() {
        System.out.println(msg + ", 狗愛吃骨頭");
    }
}
