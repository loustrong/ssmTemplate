package com.tom.ssm.spring5.chapter0708.impl;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Field;

/**
 * @descriptions: GetFieldFactoryBean
 * @author: Tom
 * @date: 2021/2/5 下午 07:48
 * @version: 1.0
 */
public class GetFieldFactoryBean implements FactoryBean<Object> {
    private String targetClass;
    private String targetField;
    // targetClass的setter方法
    public void setTargetClass(String targetClass){
        this.targetClass = targetClass;
    }
    // targetField的setter方法
    public void setTargetField(String targetField){
        this.targetField = targetField;
    }
    @Override
    public Object getObject() throws Exception {
        Class<?> clazz = Class.forName(targetClass);
        Field field = clazz.getField(targetField);
        return field.get(null);
    }

    @Override
    public Class<? extends Object> getObjectType() {
        return Object.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
