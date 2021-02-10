package com.tom.ssm.spring5.chapter0803;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @descriptions: InjectBean
 * @author: Tom
 * @date: 2021/2/9 上午 10:30
 * @version: 1.0
 */
public class InjectBean {
    private Resource res;

    public void setRes(Resource res){
        this.res = res;
    }
    public void parse() throws IOException, DocumentException {
        System.out.println(res.getFilename());
        System.out.println(res.getDescription());
        SAXReader reader = new SAXReader();
        Document doc = reader.read(res.getFile());
        Element el = doc.getRootElement();
        List l = el.elements();
        for(Iterator it = l.iterator(); it.hasNext();){
            Element book = (Element) it.next();
            List ll = book.elements();
            for(Iterator it2 = ll.iterator(); it2.hasNext();){
                Element eee = (Element) it2.next();
                System.out.println(eee.getText());
            }
        }
    }
}
