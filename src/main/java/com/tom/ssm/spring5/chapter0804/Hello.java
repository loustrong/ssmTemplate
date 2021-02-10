package com.tom.ssm.spring5.chapter0804;

/**
 * @descriptions: Hello
 * @author: Tom
 * @date: 2021/2/9 上午 11:10
 * @version: 1.0
 */
public class Hello {
    public void deleteUser(Integer id){
        System.out.println("deleteUser.");
    }
    public int addUser(String name, String pass){
        System.out.println("add name and pass is:" + name + "," + pass);
        return 20;
    }
}
