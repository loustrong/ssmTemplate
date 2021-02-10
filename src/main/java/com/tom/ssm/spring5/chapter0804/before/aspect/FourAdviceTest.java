package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @descriptions: FourAdviceTest
 * @author: Tom
 * @date: 2021/2/10 下午 02:47
 * @version: 1.0
 */
@Aspect
public class FourAdviceTest {
    @Around("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public Object processTx(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Around enforce: before execute target method, monitor beginning transaction...");
        Object[] args = jp.getArgs();
        if(args != null && args.length > 0 && args[0].getClass() == String.class){
            args[0] = "[the prefix add:]" + args[0];
        }
        Object rvt = jp.proceed(args);
        System.out.println("Around enforce: after execute method, monitor end transaction...");
        if(rvt != null && rvt instanceof Integer){
            rvt = (Integer) rvt* (Integer)rvt;
        }
        return rvt;
    }
    @Before("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public void authority(JoinPoint jp){
        System.out.println("Before Enforce: monitor execute authority check.");
        System.out.println("Before enhance:" + jp.getSignature().getName());
        System.out.println("Before enhance:" + Arrays.toString(jp.getArgs()));
        System.out.println("Before enhance:" + jp.getTarget());
    }
}
