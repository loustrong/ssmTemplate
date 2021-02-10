package com.tom.ssm.spring5.chapter0802.service.impl;

import com.tom.ssm.spring5.chapter0802.service.Axe;
import com.tom.ssm.spring5.chapter0802.service.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Component
@Scope("singleton")
@DependsOn({"steelAxe","stoneAxe"})
@Lazy
public class Chinese
	implements Person
{
	@Value("#{T(Math).PI}")
	private String name;
	private Axe axe;
	// axe��setter����
    @Resource(name="stoneAxe")
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	//
	@Override
	public void useAxe()
	{

		System.out.println(axe.chop());
	}
	@PostConstruct
    public void init(){
        System.out.println("is executing the init method.");
    }
    @PreDestroy
    public void close(){
        System.out.println("is executing the close method.");
    }
}