package com.tom.ssm.spring5.chapter0801.beanPostProcessor.util;

import com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.impl.Chinese;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * @descriptions: MyBeanProcessor
 * @author: Tom
 * @date: 2021/2/6 下午 03:08
 * @version: 1.0
 */
public class MyBeanPostProcessor
implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Bean后處理器在初始化之前對" + beanName + "進行增強處理");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean後處理器在初始化之后對" + beanName + "進行增強處理");
        if(bean instanceof Chinese){
            try{
                Class clazz = bean.getClass();
                Field f = clazz.getDeclaredField("name");
                f.setAccessible(true);
                f.set(bean, "FKJAVA:" + f.get(bean));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }


}
