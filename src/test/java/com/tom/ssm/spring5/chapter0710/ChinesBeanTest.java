package com.tom.ssm.spring5.chapter0710;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0710.xml");
        System.out.println("系統獲取sun1:" + ctx.getBean("son1"));
        System.out.println("系统获取的son1："
                + ctx.getBean("son1"));
        System.out.println("系统获取son2："
                + ctx.getBean("son2"));
        System.out.println("系统获取theAge的值："
                + ctx.getBean("theAge"));
        System.out.println("系统获取theAge2的值："
                + ctx.getBean("theAge2"));

        System.out.println("系统获取theAge1的值："
                + ctx.getBean("theAge3"));
        System.out.println("系统获取theAge2的值："
                + ctx.getBean("theAge4"));
        System.out.println("系统获取son为："
                + ctx.getBean("son2"));
    }





}
