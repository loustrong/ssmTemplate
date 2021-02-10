package com.tom.ssm.spring5.chapter0711;


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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0711.xml");
        Person p = ctx.getBean("chinese" , Person.class);
        // ����useAxe()����
        p.useAxe();
    }
    @Test
    public void testChinese070502(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-07111.xml");
        Person p = ctx.getBean("chinese1" , Person.class);
        // ����useAxe()����
        p.useAxe();
    }

    @Test
    public void testChinese070503(){
        // ����Spring����
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0711-util.xml");
        // ��ȡchineseʵ��
        com.tom.ssm.spring5.chapter0711.util.Person p = ctx.getBean("chinese" , com.tom.ssm.spring5.chapter0711.util.Person.class);
        // ����useAxe()����
        p.useAxe();
        System.out.println(ctx.getBean("confTest"));
    }

}
