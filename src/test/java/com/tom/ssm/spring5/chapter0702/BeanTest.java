package com.tom.ssm.spring5.chapter0702;

import com.tom.ssm.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descriptions: BeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 09:36
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml",
        "classpath:spring-5.xml"})
public class BeanTest {
    @Autowired
    private Person person;
    @Test
    public void testPersonBean() throws Exception {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring-5.xml");
//        Person p = ctx.getBean("person",Person.class);
        person.useAxe();

    }
    @Test
    public void testPersonWithOldStyle(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-5.xml");
        Person p = ctx.getBean("person",Person.class);
        p.useAxe();
    }



}
