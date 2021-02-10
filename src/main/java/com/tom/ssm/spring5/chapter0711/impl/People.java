package com.tom.ssm.spring5.chapter0711.impl;

import java.beans.ConstructorProperties;

/**
 * @descriptions: People
 * @author: Tom
 * @date: 2021/2/6 上午 11:24
 * @version: 1.0
 */
public class People {
    private String name;
    private int age;
    @ConstructorProperties({"name", "age"})
    public People(String name , int age)
    {
        this.name = name;
        this.age = age;
    }

    // name的setter和getter方法
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    // age的setter和getter方法
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    @Override
    public String toString()
    {
        return "Person[name=" + name + ",age="
                + this.age + "]";
    }
}
