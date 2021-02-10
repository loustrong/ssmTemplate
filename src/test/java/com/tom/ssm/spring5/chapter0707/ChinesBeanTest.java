package com.tom.ssm.spring5.chapter0707;


import com.tom.ssm.spring5.chapter0708.impl.Chinese;
import com.tom.ssm.spring5.chapter0708.impl.Japanese;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 ÉÏÎç 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0705.xml");
        Being b1 = ctx.getBean("dog", Being.class);
        Being b2 = ctx.getBean("cat", Being.class);
        b2.testBeing();
    }
    @Test
    public void testChinese070502(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0706.xml");
        Person p1 = ctx.getBean("chinese"
                , Person.class);
        System.out.println(p1.sayHello("Mary"));
        System.out.println(p1.sayGoodBye("Mary"));
        Person p2 = ctx.getBean("american"
                , Person.class);
        System.out.println(p2.sayHello("Jack"));
        System.out.println(p2.sayGoodBye("Jack"));
    }

    @Test
    public void testChinese070503(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0708.xml");
        Chinese p1 = ctx.getBean("chinese"
                , Chinese.class);
        p1.useAxe();

    }

    @Test
    public void testChinese070504(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0708.xml");
        System.out.println(ctx.getBean("north"));
        System.out.println(ctx.getBean("theValue"));
    }
    @Test
    public void testChinese070505(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0708.xml");
        Japanese japa = ctx.getBean("japanese" , Japanese.class);
        japa.info();
    }
    @Test
    public void testChinese070506(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0708.xml");
        com.tom.ssm.spring5.chapter0709.Person p = ctx.getBean("chinese1" , com.tom.ssm.spring5.chapter0709.Person.class);
        p.useAxe();
        com.tom.ssm.spring5.chapter0709.Person p1 = ctx.getBean("chinese1" , com.tom.ssm.spring5.chapter0709.Person.class);
        System.out.println("p and p1 is equal?" + (p == p1));
        p1.hunt();
        p.hunt();
        // ÎªSpringÈÝÆ÷×¢²á¹Ø±Õ¹³×Ó
        ctx.registerShutdownHook();
    }
}
