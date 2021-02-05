package com.tom.ssm.spring5.chapter0708.impl;


import com.tom.ssm.spring5.chapter0708.Axe;
import com.tom.ssm.spring5.chapter0708.Person;

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
	private String name;
	public void setAxe(Axe axe)
	{
		System.out.println("Springִ��������ϵע��...");
		this.axe = axe;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void useAxe()
	{
		System.out.println("�����й��ˣ�����Ϊ��" + name
			+ "�������ø�ͷ" + axe.chop());
	}
}