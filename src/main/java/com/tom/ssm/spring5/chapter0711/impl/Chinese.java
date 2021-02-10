package com.tom.ssm.spring5.chapter0711.impl;

import com.tom.ssm.spring5.chapter0711.Axe;
import com.tom.ssm.spring5.chapter0711.Person;
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
public class Chinese implements Person
{
	private Axe axe;
	private int age;
	public Chinese(){ }

	public Chinese(Axe axe, int age) {
		this.axe = axe;
		this.age = age;
	}

	// axe��setter����
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// age��setter����
	public void setAge(int age)
	{
		this.age = age;
	}
	// ʵ��Person�ӿڵ�useAxe()����
	@Override
	public void useAxe()
	{
		System.out.println(axe.chop());
		System.out.println("age��Ա������ֵ��" + age);
	}
}