package com.tom.ssm.spring5.chapter0707;

import com.tom.ssm.spring5.chapter0707.impl.American;
import com.tom.ssm.spring5.chapter0707.impl.Chinese;

/**
 * @descriptions: PersonFactory
 * @author: Tom
 * @date: 2021/2/5 下午 07:08
 * @version: 1.0
 */
public class PersonFactory {
    public Person getPerson(String ethnic){
        if(ethnic.equalsIgnoreCase("chin")){
            return new Chinese();
        } else {
            return new American();
        }
    }
}
