package com.tom.ssm.spring5.chapter0710;

/**
 * @descriptions: Son
 * @author: Tom
 * @date: 2021/2/6 上午 09:40
 * @version: 1.0
 */
public class Son {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "Son[age=" + age + "]";
    }
}
