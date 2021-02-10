package com.tom.ssm.spring5.chapter08.chapter0803;


import com.tom.ssm.spring5.chapter0802.autowired.domain.Item;
import com.tom.ssm.spring5.chapter0802.autowired.domain.User;
import com.tom.ssm.spring5.chapter0802.autowired.service.ItemService;
import com.tom.ssm.spring5.chapter0802.autowired.service.UserService;
import com.tom.ssm.spring5.chapter0802.service.Person;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
//import org.dom4j.*;
//import org.dom4j.io.*;
//import java.util.*;

/**
 * @descriptions: ChineseBeanTest
 * @author: Tom
 * @date: 2021/2/5 上午 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {

    @Test
    public void testChinese080202() throws IOException, DocumentException {

        // 创建一个Resource对象，指定从文件系统里读取资源
        UrlResource ur = new UrlResource("file:filePath.xml");
        // 获取该资源的简单信息
        System.out.println(ur.getFilename());
        System.out.println(ur.getDescription());
        // 创建基于SAX的dom4j解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read(ur.getFile());
        // 获取根元素
        Element el = doc.getRootElement();
        List l = el.elements();
        // 遍历根元素的全部子元素
        for (Iterator it = l.iterator(); it.hasNext() ; )
        {
            // 每个节点都是<书>节点
            Element book = (Element)it.next();
            List ll = book.elements();
            // 遍历<书>节点的全部子节点
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }


    @Test
    public void testChinese080302() throws IOException, DocumentException {

        // 创建一个Resource对象，从类加载路径里读取资源
        ClassPathResource cr = new ClassPathResource("classPath.xml");
        // 获取该资源的简单信息
        System.out.println(cr.getFilename());
        System.out.println(cr.getDescription());
        // 创建基于SAX的dom4j解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read(cr.getFile());
        // 获取根元素
        Element el = doc.getRootElement();
        List l = el.elements();
        // 遍历根元素的全部子元素
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // 每个节点都是<书>节点
            Element book = (Element)it.next();
            List ll = book.elements();
            // 遍历<书>节点的全部子节点
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }

    @Test
    public void testChinese080303() throws IOException, DocumentException {

        // 默认从文件系统的当前路径加载book.xml资源
        FileSystemResource fr = new FileSystemResource("fileSystemPath.xml");
        // 获取该资源的简单信息
        System.out.println(fr.getFilename());
        System.out.println(fr.getDescription());
        // 创建基于SAX的dom4j解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read(fr.getFile());
        // 获取根元素
        Element el = doc.getRootElement();
        List l = el.elements();
        // 遍历根元素的全部子元素
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // 每个节点都是<书>节点
            Element book = (Element)it.next();
            List ll = book.elements();
            // 遍历<书>节点的全部子节点
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }

    }


    @Test
    public void testChinese080304() throws IOException, DocumentException {

        String file = "<?xml version='1.0' encoding='GBK'?>"
                + "<计算机书籍列表><书><书名>疯狂Java讲义"
                + "</书名><作者>李刚</作者></书><书><书名>"
                + "轻量级Java EE企业应用实战</书名><作者>李刚"
                + "</作者></书></计算机书籍列表>";
        byte[] fileBytes = file.getBytes();
        // 以字节数组作为资源来创建Resource对象
        ByteArrayResource bar = new ByteArrayResource(fileBytes);
        // 获取该资源的简单信息
        System.out.println(bar.getDescription());
        // 创建基于SAX的dom4j解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read(bar.getInputStream());
        // 获取根元素
        Element el = doc.getRootElement();
        List l = el.elements();
        // 遍历根元素的全部子元素
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // 每个节点都是<书>节点
            Element book = (Element)it.next();
            List ll = book.elements();
            // 遍历<书>节点的全部子节点
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }


    @Test
    public void testChinese080305() throws IOException, DocumentException {
// 创建ApplicationContext实例
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("resourceLoader.xml");
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("beans.xml");
        Resource res = ctx.getResource("resourceLoader.xml");
        // 获取该资源的简单信息
        System.out.println(res.getFilename());
        System.out.println(res.getDescription());
        // 创建基于SAX的dom4j解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read(res.getFile());
        // 获取根元素
        Element el = doc.getRootElement();
        List l = el.elements();
        // 遍历根元素的全部子元素
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // 每个节点都是<书>节点
            Element book = (Element)it.next();
            List ll = book.elements();
            // 遍历<书>节点的全部子节点
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }

    }

}


