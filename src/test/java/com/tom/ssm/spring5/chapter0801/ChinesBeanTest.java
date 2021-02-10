package com.tom.ssm.spring5.chapter0801;



import com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.Person;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {


    @Test
    public void testChinese071202() throws SQLException {
        Resource isr = new ClassPathResource("config/spring-0801.xml");
        // 创建默认的BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 让默认的BeanFactory容器加载isr对应的XML配置文件
        new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
        // 获取容器中的Bean后处理器
        BeanPostProcessor bp = (BeanPostProcessor)beanFactory.getBean("bp");
        // 注册Bean后处理器
        beanFactory.addBeanPostProcessor(bp);
//        Person p = (Person)beanFactory.getBean("chinese");
//
//        p.useAxe();

        // 以ApplicationContex作为Spring容器
        // 它会自动注册容器后处理器、Bean后处理器
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0801.xml");
        Person p1 = (Person)ctx.getBean("chinese");
        p1.useAxe();
        DataSource ds = (DataSource)ctx.getBean("dataSource");
        Connection conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
                "insert into news_inf value(null , ? , ?)");
        pstmt.setString(1 , "Spring8.1.1");
        pstmt.setString(2 , "Spring8.1.2");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }

    @Test
    public void testChinese071203() throws SQLException {


        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-08011.xml");
        DataSource ds = (DataSource)ctx.getBean("dataSource");
        Connection conn = ds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
                "insert into news_inf value(null , ? , ?)");
        pstmt.setString(1 , "瑁遼Java蔡砱");
        pstmt.setString(2 , "瑁遼iOS蔡砱");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }



    @Test
    public void testChinese080201() throws SQLException {


        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("config/spring-0802.xml");
        System.out.println("--------------" +
                java.util.Arrays.toString(ctx.getBeanDefinitionNames()));
    }

}
