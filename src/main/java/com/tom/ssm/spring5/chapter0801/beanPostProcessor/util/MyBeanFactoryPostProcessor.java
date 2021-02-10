package com.tom.ssm.spring5.chapter0801.beanPostProcessor.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @descriptions: MyBeanFactoryPostProcessor
 * @author: Tom
 * @date: 2021/2/6 下午 04:01
 * @version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ConfigurableListableBeanFactory");
        System.out.println("Spring Container IS:" + beanFactory);
    }
}
