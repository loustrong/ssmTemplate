package com.tom.ssm.spring5.chapter0712.grammer;

/**
 * @descriptions: grammer.Person
 * @author: Tom
 * @date: 2021/2/6 下午 02:44
 * @version: 1.0
 */
public class Person
{
    private Integer id;
    private String name;
    private int height;

    public Person()
    {
    }
    // 初始化全部成员变量的构造器
    public Person(Integer id , String name , int height)
    {
        this.id = id;
        this.name = name;
        this.height = height;
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

    // height的setter和getter方法
    public void setHeight(int height)
    {
        this.height = height;
    }
    public int getHeight()
    {
        return this.height;
    }

}
