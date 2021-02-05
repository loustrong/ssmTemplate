package com.tom.ssm.spring5.chapter0708.impl;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @descriptions: Japanese
 * @author: Tom
 * @date: 2021/2/5 下午 08:04
 * @version: 1.0
 */
public class Japanese implements BeanNameAware {
    private String beanName;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
    public void info(){
        System.out.println("Japanese實現類"
        + ", 部署該bean時指定的id為:" + beanName);
    }
}
