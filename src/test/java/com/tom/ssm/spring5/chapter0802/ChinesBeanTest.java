package com.tom.ssm.spring5.chapter0802;





import com.tom.ssm.spring5.chapter0804.Hello;
import com.tom.ssm.spring5.chapter0802.autowired.domain.Item;
import com.tom.ssm.spring5.chapter0802.autowired.domain.User;
import com.tom.ssm.spring5.chapter0802.autowired.service.ItemService;
import com.tom.ssm.spring5.chapter0802.autowired.service.UserService;
import com.tom.ssm.spring5.chapter0802.service.Person;
import com.tom.ssm.spring5.chapter0803.InjectBean;
import com.tom.ssm.spring5.chapter0803.TestBean;
import com.tom.ssm.spring5.chapter0804.World;
import org.dom4j.DocumentException;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;


/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {


    @Test
    public void testChinese080201() {

        AbstractApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0802.xml");
        Person p1 = (Person)ctx.getBean("chinese");
        p1.useAxe();
        ctx.registerShutdownHook();

    }
    @Test
    public void testChinese080202() {

        AbstractApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-08012.xml");
        com.tom.ssm.spring5.chapter0802.primary.Person p1 = ctx.getBean("chinese", com.tom.ssm.spring5.chapter0802.primary.Person.class);
        p1.test();

    }
    @Test
    public void testChinese080203() {

        AbstractApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-08022.xml");
        UserService us = ctx.getBean("userService", UserService.class);
        us.addEntity(new User());
        ItemService is = ctx.getBean("itemService", ItemService.class);
        is.addEntity(new Item());
    }

    @Test
    public void testChinese080304() {

        AbstractApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-08022.xml");
        com.tom.ssm.spring5.chapter0802.qualify.Person p = ctx.getBean("chinese" , com.tom.ssm.spring5.chapter0802.qualify.Person.class);
        p.useAxe();
    }

    @Test
    public void testChinese080305() {
// 创建ApplicationContext容器
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0803.xml");
        // 获取容器中名为test的Bean实例
        TestBean tb = ctx.getBean("test" , TestBean.class);
        // 通过tb实例来获取ResourceLoader对象
        ResourceLoader rl = tb.getResourceLoader();
        // 判断程序获得ResourceLoader和容器是否相同
        System.out.println(rl == ctx);
    }


    @Test
    public void testChinese080306() throws IOException, DocumentException {
// 创建ApplicationContext容器
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0804.xml");
        InjectBean tb = ctx.getBean("test" , InjectBean.class);
        tb.parse();
    }

    @Test
    public void testChinese080401() throws IOException, DocumentException {
        Hello hello = new Hello();
        hello.addUser("孙悟空" , "7788");
        hello.deleteUser(1);
        World world = new World();
        world.bar();
    }

    @Test
    public void testChinese080402() throws IOException, DocumentException {

        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-080401.xml");
        com.tom.ssm.spring5.chapter0804.before.Hello hello = ctx.getBean("hello", com.tom.ssm.spring5.chapter0804.before.Hello.class);
        hello.addUser("孙悟空", "7788");
        hello.deleteUser(1);
//        hello.deleteUser(-1);
        com.tom.ssm.spring5.chapter0804.before.World world = ctx.getBean("world", com.tom.ssm.spring5.chapter0804.before.World.class);
        world.bar();
    }


    @Test
    public void testChinese080403()  {

        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0805.xml");
        com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService us = ctx.getBean("userService" , com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService.class);
        // 第一次调用us对象的方法时会执行该方法，并缓存方法的结果
        com.tom.ssm.spring5.chapter0805.simpleCache.domain.User u1 = us.getUsersByNameAndAge("孙悟空", 500);
        // 第二次调用us对象的方法时直接利用缓存的数据，并不真正执行该方法
        com.tom.ssm.spring5.chapter0805.simpleCache.domain.User u2 = us.getAnotherUser("孙悟空", 500);
        System.out.println(u1 == u2); // 输出true
    }

    @Test
    public void testChinese080501()  {

        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-080501.xml");
        com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService us = ctx.getBean("userService" , com.tom.ssm.spring5.chapter0805.simpleCache.service.UserService.class);
        // 第一次调用us对象的方法时会执行该方法，并缓存方法的结果
        com.tom.ssm.spring5.chapter0805.simpleCache.domain.User u1 = us.getUsersByNameAndAge("孙悟空", 500);
        // 第二次调用us对象的方法时直接利用缓存的数据，并不真正执行该方法
        com.tom.ssm.spring5.chapter0805.simpleCache.domain.User u2 = us.getAnotherUser("孙悟空", 500);
        System.out.println(u1 == u2); // 输出true
    }
}
