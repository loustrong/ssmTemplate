package com.tom.ssm.spring5.chapter0706.impl;

import com.tom.ssm.spring5.chapter0706.Axe;

/**
 * @descriptions: SteelAxe
 * @author: Tom
 * @date: 2021/2/5 下午 06:18
 * @version: 1.0
 */
public class StoneAxe implements Axe
{
    public String chop()
    {
        return "Stone is slow.";
    }
}
