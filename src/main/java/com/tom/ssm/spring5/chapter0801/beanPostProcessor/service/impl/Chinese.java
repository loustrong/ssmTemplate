package com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.impl;

import com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.Axe;
import com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class Chinese
	implements Person,InitializingBean
{
	private Axe axe;
	private String name;
	public Chinese()
	{
		System.out.println("Springʵ��������bean��Chineseʵ��...");
	}
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	public void setName(String name)
	{
		System.out.println("Springִ��setName()����ע��������ϵ...");
		this.name = name;
	}
	@Override
	public void useAxe()
	{
		System.out.println(name + axe.chop());
	}
	// �����������������ڷ���
	public void init()
	{
		System.out.println("is init...");
	}
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("ok. afterPropertiesSet...");
	}
}