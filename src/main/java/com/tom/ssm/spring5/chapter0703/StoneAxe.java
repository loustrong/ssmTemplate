package com.tom.ssm.spring5.chapter0703;

/**
 * @descriptions: StoneAxe
 * @author: Tom
 * @date: 2021/2/5 上午 09:56
 * @version: 1.0
 */
public class StoneAxe implements com.tom.ssm.spring5.chapter0703.Axe{
    @Override
    public String chop() {
        return "Stone Axe chop slowly!";
    }
}
