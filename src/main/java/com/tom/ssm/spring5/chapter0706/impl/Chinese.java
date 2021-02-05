package com.tom.ssm.spring5.chapter0706.impl;

import com.tom.ssm.spring5.chapter0706.Axe;
import com.tom.ssm.spring5.chapter0706.Person;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/5 下午 06:15
 * @version: 1.0
 */
public class Chinese implements Person
{
    private Axe axe;
    private String name;
    // axe的setter方法
    public void setAxe(Axe axe)
    {
        this.axe = axe;
    }
    // name的setter方法
    public void setName(String name)
    {
        this.name = name;
    }
    // 实现Person接口的useAxe()方法
    public void useAxe()
    {
        // 调用axe的chop()方法，表明Person对象依赖于axe对象
        System.out.println("我是："	+ name
                + axe.chop());
    }
}
