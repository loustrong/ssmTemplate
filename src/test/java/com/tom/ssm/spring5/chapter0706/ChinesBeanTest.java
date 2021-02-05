package com.tom.ssm.spring5.chapter0706;

import com.tom.ssm.spring5.chapter0705.ExampleBean;
import com.tom.ssm.spring5.chapter0705.impl.Chinese;
import com.tom.ssm.spring5.chapter0706.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testChinese070501(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person p = ctx.getBean("chinese" , Person.class);
        // 调用useAxe()方法
        p.useAxe();
    }


}
