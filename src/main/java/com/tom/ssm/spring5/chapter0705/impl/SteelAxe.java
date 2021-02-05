package com.tom.ssm.spring5.chapter0705.impl;

import com.tom.ssm.spring5.chapter0705.Axe;

/**
 * @descriptions: SteelAxe
 * @author: Tom
 * @date: 2021/2/5 下午 02:43
 * @version: 1.0
 */
public class SteelAxe implements Axe {
    @Override
    public String chop(){
        return "Steel Axe";
    }
}
