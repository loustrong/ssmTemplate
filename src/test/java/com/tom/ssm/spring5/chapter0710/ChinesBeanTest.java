package com.tom.ssm.spring5.chapter0710;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 ���� 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0710.xml");
        System.out.println("ϵ�y�@ȡsun1:" + ctx.getBean("son1"));
        System.out.println("ϵͳ��ȡ��son1��"
                + ctx.getBean("son1"));
        System.out.println("ϵͳ��ȡson2��"
                + ctx.getBean("son2"));
        System.out.println("ϵͳ��ȡtheAge��ֵ��"
                + ctx.getBean("theAge"));
        System.out.println("ϵͳ��ȡtheAge2��ֵ��"
                + ctx.getBean("theAge2"));

        System.out.println("ϵͳ��ȡtheAge1��ֵ��"
                + ctx.getBean("theAge3"));
        System.out.println("ϵͳ��ȡtheAge2��ֵ��"
                + ctx.getBean("theAge4"));
        System.out.println("ϵͳ��ȡsonΪ��"
                + ctx.getBean("son2"));
    }





}
