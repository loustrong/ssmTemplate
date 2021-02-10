package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @descriptions: TxAspect
 * @author: Tom
 * @date: 2021/2/10 下午 02:36
 * @version: 1.0
 */
@Aspect
public class TxAspect {
    @Around("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("before method, begin monitoring transaction...");
        Object[] args = jp.getArgs();
        if(args != null && args.length > 1){
            args[0] = "[add the prefix]" + args[0];
        }
        // 以改變之後的參數去執行目標方法,并保存目標方法執行后的返回值
        Object rvt = jp.proceed(args);
        System.out.println("after execute the method, monitor the method end.");
        if(rvt != null && rvt instanceof Integer) rvt = (Integer) rvt * (Integer) rvt;
        return rvt;
    }
}
