package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @descriptions: LogAspect
 * @author: Tom
 * @date: 2021/2/10 下午 02:14
 * @version: 1.0
 */
@Aspect
public class LogAspect {
    @AfterReturning(returning="rvt",
//    pointcut = "execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))"
            pointcut = "com.tom.ssm.spring5.chapter0804.before.aspect.SystemArchitecture.myPoinCut()"
    )
    public void log(Object rvt){
        System.out.println("獲取目標方法的返回值:" + rvt);
        System.out.println("模擬記錄日誌功能.");
    }
}
