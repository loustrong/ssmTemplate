package com.tom.ssm.spring5.chapter0709.impl;

import com.tom.ssm.spring5.chapter0709.Axe;
import com.tom.ssm.spring5.chapter0709.Dog;
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
public abstract class Chinese implements Person, InitializingBean,
        BeanNameAware, ApplicationContextAware {
    private Axe axe;
    private Dog dog;
    public abstract Dog getDog();

    @Override
    public void hunt(){
        System.out.println("I and " + this.getDog() + " go hunting.");
        System.out.println(this.getDog().run());
    }
    public Chinese()
    {
        System.out.println("Spring实例化主调bean：Chinese实例...");
    }
    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("====setBeanName===");
    }

    // 测试用的初始化方法
    public void init()
    {
        System.out.println("正在执行初始化方法 init...");
    }
    // 实现InitializingBean接口必须实现的方法
    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("正在执行初始化方法 afterPropertiesSet...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("===setApplicationContext===");
    }
    // axe的setter方法
    public void setAxe(Axe axe)
    {
        System.out.println("Spring调用setAxe()执行依赖注入...");
        this.axe = axe;
    }

    public void close()
    {
        System.out.println("正在执行销毁之前的方法 close...");
    }
    public void destroy() throws Exception
    {
        System.out.println("正在执行销毁之前的方法 destroy...");
    }

}
