package com.tom.ssm.spring5.chapter0703;

/**
 * @descriptions: Japenese
 * @author: Tom
 * @date: 2021/2/5 上午 11:11
 * @version: 1.0
 */
public class Japanese implements Person{
    private Axe axe;
    public Japanese(Axe axe){
        this.axe = axe;
    }
    @Override
    public void useAxe() {
        System.out.println("japenese use steel.");
    }
}
