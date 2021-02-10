package com.tom.ssm.spring5.chapter0804;

public aspect AuthAspect {
    before(): execution(* com.tom.ssm.spring5.chapter0804.*.*(..))
            {
                System.out.println("monitor authority check.");
            }
}
