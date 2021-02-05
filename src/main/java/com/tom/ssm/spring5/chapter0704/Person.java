package com.tom.ssm.spring5.chapter0704;

/**
 * @descriptions: Person
 * @author: Tom
 * @date: 2021/2/5 上午 11:17
 * @version: 1.0
 */
public class Person {
    public Person(){
        System.out.println("==正在執行 Person 無參構造器");
    }
    public void setTest(String name){
        System.out.println("is calling setName() Method, parameter is "+ name);
    }
}
