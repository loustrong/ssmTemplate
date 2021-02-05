package com.tom.ssm.spring5.chapter0704;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import javax.xml.transform.Source;

/**
 * @descriptions: EmailEvent
 * @author: Tom
 * @date: 2021/2/5 下午 01:19
 * @version: 1.0
 */
public class EmailEvent extends ApplicationEvent {
    private String address;
    private String text;
    public EmailEvent(Object source){
        super(source);
    }
    public EmailEvent(Object source, String address, String text){
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
