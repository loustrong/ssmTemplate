package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @descriptions: ReleaseAspect
 * @author: Tom
 * @date: 2021/2/10 下午 02:29
 * @version: 1.0
 */
@Aspect
public class ReleaseAspect {
    @After("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public void release(){
        System.out.println("~~~~~0804~~~monitor after method and release the resource.");
    }
}
