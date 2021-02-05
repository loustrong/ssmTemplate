package com.tom.ssm.spring5.chapter0703;

/**
 * @descriptions: Chinese
 * @author: Tom
 * @date: 2021/2/5 上午 09:54
 * @version: 1.0
 */
public class Chinese implements com.tom.ssm.spring5.chapter0703.Person {
    private com.tom.ssm.spring5.chapter0703.Axe axe;
    public void setAxe(com.tom.ssm.spring5.chapter0703.Axe axe){
        this.axe = axe;
    }
    @Override
    public void useAxe(){
        System.out.println(axe.chop());
    }

}
