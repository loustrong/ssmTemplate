package com.tom.ssm.spring5.chapter0707;

import com.tom.ssm.spring5.chapter0707.impl.Cat;
import com.tom.ssm.spring5.chapter0707.impl.Dog;

/**
 * @descriptions: BeingFactory
 * @author: Tom
 * @date: 2021/2/5 下午 06:56
 * @version: 1.0
 */
public class BeingFactory {
    public static Being getBeing(String arg){
        if(arg.equalsIgnoreCase("dog")){
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
