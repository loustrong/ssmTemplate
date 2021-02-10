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
 * @date: 2021/2/5 ���� 10:22
 * @version: 1.0
 */
public class ChinesBeanTest {

    @Test
    public void testChinese080202() throws IOException, DocumentException {

        // ����һ��Resource����ָ�����ļ�ϵͳ���ȡ��Դ
        UrlResource ur = new UrlResource("file:filePath.xml");
        // ��ȡ����Դ�ļ���Ϣ
        System.out.println(ur.getFilename());
        System.out.println(ur.getDescription());
        // ��������SAX��dom4j������
        SAXReader reader = new SAXReader();
        Document doc = reader.read(ur.getFile());
        // ��ȡ��Ԫ��
        Element el = doc.getRootElement();
        List l = el.elements();
        // ������Ԫ�ص�ȫ����Ԫ��
        for (Iterator it = l.iterator(); it.hasNext() ; )
        {
            // ÿ���ڵ㶼��<��>�ڵ�
            Element book = (Element)it.next();
            List ll = book.elements();
            // ����<��>�ڵ��ȫ���ӽڵ�
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }


    @Test
    public void testChinese080302() throws IOException, DocumentException {

        // ����һ��Resource���󣬴������·�����ȡ��Դ
        ClassPathResource cr = new ClassPathResource("classPath.xml");
        // ��ȡ����Դ�ļ���Ϣ
        System.out.println(cr.getFilename());
        System.out.println(cr.getDescription());
        // ��������SAX��dom4j������
        SAXReader reader = new SAXReader();
        Document doc = reader.read(cr.getFile());
        // ��ȡ��Ԫ��
        Element el = doc.getRootElement();
        List l = el.elements();
        // ������Ԫ�ص�ȫ����Ԫ��
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // ÿ���ڵ㶼��<��>�ڵ�
            Element book = (Element)it.next();
            List ll = book.elements();
            // ����<��>�ڵ��ȫ���ӽڵ�
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }

    @Test
    public void testChinese080303() throws IOException, DocumentException {

        // Ĭ�ϴ��ļ�ϵͳ�ĵ�ǰ·������book.xml��Դ
        FileSystemResource fr = new FileSystemResource("fileSystemPath.xml");
        // ��ȡ����Դ�ļ���Ϣ
        System.out.println(fr.getFilename());
        System.out.println(fr.getDescription());
        // ��������SAX��dom4j������
        SAXReader reader = new SAXReader();
        Document doc = reader.read(fr.getFile());
        // ��ȡ��Ԫ��
        Element el = doc.getRootElement();
        List l = el.elements();
        // ������Ԫ�ص�ȫ����Ԫ��
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // ÿ���ڵ㶼��<��>�ڵ�
            Element book = (Element)it.next();
            List ll = book.elements();
            // ����<��>�ڵ��ȫ���ӽڵ�
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
                + "<������鼮�б�><��><����>���Java����"
                + "</����><����>���</����></��><��><����>"
                + "������Java EE��ҵӦ��ʵս</����><����>���"
                + "</����></��></������鼮�б�>";
        byte[] fileBytes = file.getBytes();
        // ���ֽ�������Ϊ��Դ������Resource����
        ByteArrayResource bar = new ByteArrayResource(fileBytes);
        // ��ȡ����Դ�ļ���Ϣ
        System.out.println(bar.getDescription());
        // ��������SAX��dom4j������
        SAXReader reader = new SAXReader();
        Document doc = reader.read(bar.getInputStream());
        // ��ȡ��Ԫ��
        Element el = doc.getRootElement();
        List l = el.elements();
        // ������Ԫ�ص�ȫ����Ԫ��
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // ÿ���ڵ㶼��<��>�ڵ�
            Element book = (Element)it.next();
            List ll = book.elements();
            // ����<��>�ڵ��ȫ���ӽڵ�
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }
    }


    @Test
    public void testChinese080305() throws IOException, DocumentException {
// ����ApplicationContextʵ��
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("resourceLoader.xml");
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("beans.xml");
        Resource res = ctx.getResource("resourceLoader.xml");
        // ��ȡ����Դ�ļ���Ϣ
        System.out.println(res.getFilename());
        System.out.println(res.getDescription());
        // ��������SAX��dom4j������
        SAXReader reader = new SAXReader();
        Document doc = reader.read(res.getFile());
        // ��ȡ��Ԫ��
        Element el = doc.getRootElement();
        List l = el.elements();
        // ������Ԫ�ص�ȫ����Ԫ��
        for (Iterator it = l.iterator();it.hasNext() ; )
        {
            // ÿ���ڵ㶼��<��>�ڵ�
            Element book = (Element)it.next();
            List ll = book.elements();
            // ����<��>�ڵ��ȫ���ӽڵ�
            for (Iterator it2 = ll.iterator();it2.hasNext() ; )
            {
                Element eee = (Element)it2.next();
                System.out.println(eee.getText());
            }
        }

    }

}


