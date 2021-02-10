package com.tom.ssm.spring5.chapter0709.impl;

import com.tom.ssm.spring5.chapter0709.Dog;

/**
 * @descriptions: GunDog
 * @author: Tom
 * @date: 2021/2/6 上午 09:26
 * @version: 1.0
 */
public class GunDog implements Dog
{
    private String name;
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public String run()
    {
        return "我是一只叫" + getName()
                + "的猎犬，奔跑迅速..." ;
    }
}
