package com.tom.ssm.spring5.chapter0709.impl;

import com.tom.ssm.spring5.chapter0709.Axe;

/**
 * @descriptions: SteelAxe
 * @author: Tom
 * @date: 2021/2/5 下午 08:15
 * @version: 1.0
 */
public class SteelAxe
        implements Axe
{
    public SteelAxe()
    {
        System.out.println("Spring实例化依赖bean：SteelAxe实例...");
    }
    public String chop()
    {
        return "钢斧砍柴真快";
    }
}
