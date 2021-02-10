package com.tom.ssm.spring5.chapter0712.domain;

import java.util.Date;

/**
 * @descriptions: Person
 * @author: Tom
 * @date: 2021/2/6 下午 02:25
 * @version: 1.0
 */
public class Person
{
    private Integer id;
    private String name;
    private Date birth;

    // 无参数的构造器
    public Person()
    {
    }
    // 初始化全部成员变量的构造器
    public Person(Integer id , String name , Date birth)
    {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    // id的setter和getter方法
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getId()
    {
        return this.id;
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

    // birth的setter和getter方法
    public void setBirth(Date birth)
    {
        this.birth = birth;
    }
    public Date getBirth()
    {
        return this.birth;
    }
}
