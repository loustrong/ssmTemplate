package com.tom.ssm.spring5.chapter0703;

import com.tom.ssm.spring5.chapter0703.Person;
import com.tom.ssm.spring5.chapter0704.EmailEvent;
import com.tom.ssm.spring5.chapter0704.ExampleBean;
import com.tom.ssm.spring5.chapter0704.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese0703(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0703.xml");
        Person person = ctx.getBean("chinese", Person.class);
        person.useAxe();
    }
    @Test
    public void testJapenese0703(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0703.xml");
        Person person = ctx.getBean("japenese", Person.class);
        person.useAxe();
    }
    @Test
    public void testJapenese0704(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0704.xml");
        com.tom.ssm.spring5.chapter0704.Person person = ctx.getBean("chinese",com.tom.ssm.spring5.chapter0704.Person.class);
        person.setTest("hello");
    }

    @Test
    public void testJapenese070402(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0704.xml");
        // 使用getMessage()方法获取本地化消息。
        // Locale的getDefault方法返回计算机环境的默认Locale
        String hello = ctx.getMessage("hello" , new String[]{"孙悟空"}
                , Locale.getDefault(Locale.Category.FORMAT));
        String now = ctx.getMessage("now" , new Object[]{new Date()}
                , Locale.getDefault(Locale.Category.FORMAT));
        // 打印出两条本地化消息
        System.out.println(hello);
        System.out.println(now);
    }


    @Test
    public void testJapenese070403(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0704.xml");
        EmailEvent ele = new EmailEvent("test","spring_test@163.com","This is a test");
        ctx.publishEvent(ele);
    }

    @Test
    public void testSpringApplicationAware(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0704.xml");
        People people = ctx.getBean("people", People.class);
        people.sayHi("Tom");
        People people1 = ctx.getBean("people", People.class);
        System.out.println("isEqual?" + (people == people1));
    }
    @Test
    public void testJapenese070405(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0704.xml");

        ExampleBean b = ctx.getBean("exampleBean"
                , ExampleBean.class);
        System.out.println(b.getIntegerField());
        System.out.println(b.getDoubleField());
    }
}
