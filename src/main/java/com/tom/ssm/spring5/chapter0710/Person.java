package com.tom.ssm.spring5.chapter0710;

/**
 * @descriptions: Person
 * @author: Tom
 * @date: 2021/2/6 上午 09:39
 * @version: 1.0
 */
public class Person {
    private int age;
    private Son son;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
