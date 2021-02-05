package com.tom.ssm.spring5.chapter0705;

import com.tom.ssm.spring5.chapter0703.Person;
import com.tom.ssm.spring5.chapter0704.EmailEvent;
import com.tom.ssm.spring5.chapter0704.People;
import com.tom.ssm.spring5.chapter0705.impl.Chinese;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 ���� 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {
    @Test
    public void testChinese070501(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0705.xml");
        Chinese p = ctx.getBean("chinese" , Chinese.class);
        p.test();
    }
    @Test
    public void testChinese070502(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0705.xml");
        ExampleBean p = ctx.getBean("exampleBean", ExampleBean.class);
        System.out.println(p.getPeople());
    }

    @Test
    public void testDatasource070503() throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-0705.xml");
        DataSource ds = ctx.getBean("dataSource", DataSource.class);
        // ͨ��DataSource����ȡ���ݿ�����
        Connection conn = ds.getConnection();
        // ͨ�����ݿ����ӻ�ȡPreparedStatement
        PreparedStatement pstmt = conn.prepareStatement(
                "insert into news_inf values(null , ? , ?)");
        pstmt.setString(1 , "���Java���˳�����");
        pstmt.setString(2 , "���Java��ַ��www.crazyit.org");
        // ִ��SQL���
        pstmt.executeUpdate();
        // ������Դ���������ݿ�������Դ��
        if (pstmt != null)pstmt.close();
        if (conn != null)conn.close();
    }

}
