package com.tom.ssm.spring5.chapter0709.impl;

import com.tom.ssm.spring5.chapter0709.Axe;
import com.tom.ssm.spring5.chapter0709.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/5 下午 08:12
 * @version: 1.0
 */
public class Chinese implements Person, InitializingBean,
        BeanNameAware, ApplicationContextAware {
    private Axe axe;
    public Chinese()
    {
        System.out.println("Spring实例化主调bean：Chinese实例...");
    }
    @Override
    public void useAxe() {

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("====setBeanName===");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("===setApplicationContext===");
    }
}
