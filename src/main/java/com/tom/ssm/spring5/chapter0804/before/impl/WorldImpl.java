package com.tom.ssm.spring5.chapter0804.before.impl;

import com.tom.ssm.spring5.chapter0804.before.World;
import org.springframework.stereotype.Component;

/**
 * @descriptions: WorldImpl
 * @author: Tom
 * @date: 2021/2/10 下午 01:53
 * @version: 1.0
 */
@Component("world")
public class WorldImpl implements World {
    @Override
    public void bar() {
        System.out.println("~~~before0804~~~execute world bar method.");
    }
}
