package com.tom.ssm.spring5.chapter0705;

/**
 * @descriptions: Peaople
 * @author: Tom
 * @date: 2021/2/5 下午 05:57
 * @version: 1.0
 */
public class People {
    private String name;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
