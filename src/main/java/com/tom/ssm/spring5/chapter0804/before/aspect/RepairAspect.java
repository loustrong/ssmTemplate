package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @descriptions: RepairAspect
 * @author: Tom
 * @date: 2021/2/10 下午 02:20
 * @version: 1.0
 */
@Aspect
public class RepairAspect {

    @AfterThrowing(throwing = "ex", pointcut = "execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")

    public void doRecoveryActions(Throwable ex){ // 該處定義為Throwable,意思是拋出的是接受的拋出的異常是Throwable
        System.out.println("target method throw the exception is:" + ex);
        System.out.println("monitor Advice fix exception.");
    }
}
