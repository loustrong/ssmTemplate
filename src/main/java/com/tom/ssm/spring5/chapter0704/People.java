package com.tom.ssm.spring5.chapter0704;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

/**
 * @descriptions: People
 * @author: Tom
 * @date: 2021/2/5 下午 01:35
 * @version: 1.0
 */
public class People implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public void sayHi(String name){
        System.out.println(applicationContext.getMessage("hello", new String[]{name},
                Locale.getDefault(Locale.Category.FORMAT)));
    }
}
