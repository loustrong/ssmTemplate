package com.tom.ssm.spring5.chapter0703;

/**
 * @descriptions: SteelAxe
 * @author: Tom
 * @date: 2021/2/5 上午 11:09
 * @version: 1.0
 */
public class SteelAxe implements Axe{
    @Override
    public String chop() {
        return "Steel Axe fast.";
    }
}
