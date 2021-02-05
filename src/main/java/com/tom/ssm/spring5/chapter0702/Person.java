package com.tom.ssm.spring5.chapter0702;

/**
 * @descriptions: Person
 * @author: Tom
 * @date: 2021/2/5 上午 09:26
 * @version: 1.0
 */
public class Person {
    private Axe axe;
    public void setAxe(Axe axe){
        this.axe = axe;
    }
    public void useAxe(){
        System.out.println("我打算去砍柴點火!");
        System.out.println(axe.chop());
    }
}
