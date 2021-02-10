package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @descriptions: SystemArchitecture
 * @author: Tom
 * @date: 2021/2/10 下午 03:15
 * @version: 1.0
 */
public class SystemArchitecture {
    @Pointcut("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public void myPoinCut(){}
}
