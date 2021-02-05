package com.tom.ssm.spring5.chapter0705.impl;

import com.tom.ssm.spring5.chapter0705.Axe;

/**
 * @descriptions: StoneAxe
 * @author: Tom
 * @date: 2021/2/5 下午 02:44
 * @version: 1.0
 */
public class StoneAxe implements Axe {
    @Override
    public String chop() {
        return "Stone Axe";
    }
}
