package com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.impl;

import com.tom.ssm.spring5.chapter0801.beanPostProcessor.service.Axe;

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
public class SteelAxe
	implements Axe
{
	public SteelAxe()
	{
		System.out.println("Springʵ��������bean��SteelAxeʵ��...");
	}
	@Override
	public String chop()
	{
		return "�ָ��������";
	}
}