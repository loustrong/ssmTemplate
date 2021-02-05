package com.tom.ssm.spring5.chapter0704;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @descriptions:
 * @author: Tom
 * @date: 2021/2/5 下午 01:25
 * @version: 1.0
 */
public class EmailNotifier implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof EmailEvent){
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("需要發送郵件的接收地址:" + ((EmailEvent) event).getAddress());
            System.out.println("需要發送郵件的郵件正文:" + emailEvent.getText());
        }else{
            System.out.println("其他事件:" + event);
        }
    }
}
