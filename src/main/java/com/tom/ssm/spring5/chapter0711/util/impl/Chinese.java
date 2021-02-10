package com.tom.ssm.spring5.chapter0711.util.impl;

import com.tom.ssm.spring5.chapter0711.util.Axe;
import com.tom.ssm.spring5.chapter0711.util.Person;

import java.util.*;

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
	private List schools;
	private Map scores;
	private Set axes;

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
	// schools��setter����
	public void setSchools(List schools)
	{
		this.schools = schools;
	}
	// scores��setter����
	public void setScores(Map scores)
	{
		this.scores = scores;
	}
	// axes��setter����
	public void setAxes(Set axes)
	{
		this.axes = axes;
	}
	// ʵ��Person�ӿڵ�useAxe()����
	@Override
	public void useAxe()
	{
		System.out.println(axe.chop());
		System.out.println("age����ֵ��" + age);
		System.out.println(schools);
		System.out.println(scores);
		System.out.println(axes);
	}
}