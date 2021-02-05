package com.tom.ssm.spring5.chapter0704;

/**
 * Description:
 * <br/>???: <a href="http://www.crazyit.org">???Java????</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ExampleBean
{
	// 定义一个int型的成员变量
	private int integerField;
	// 定义一个double型的成员变量
	private double doubleField;

	// integerField的setter和getter方法
	public void setIntegerField(int integerField)
	{
		this.integerField = integerField;
	}
	public int getIntegerField()
	{
		return this.integerField;
	}

	// doubleField的setter和getter方法
	public void setDoubleField(double doubleField)
	{
		this.doubleField = doubleField;
	}
	public double getDoubleField()
	{
		return this.doubleField;
	}
}