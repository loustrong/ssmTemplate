package com.tom.ssm.spring5.chapter0804.before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @descriptions: AuthAspect
 * @author: Tom
 * @date: 2021/2/10 下午 01:57
 * @version: 1.0
 */
// 定義一個切面
@Aspect
public class AuthAspect {
  @Before("execution(* com.tom.ssm.spring5.chapter0804.before.impl.*.*(..))")
    public void authority(){
      System.out.println("~~~before0804~~~before is authority.");
  }
}
