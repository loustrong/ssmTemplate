package com.tom.ssm.servelet.chapter0210;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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

@WebListener
public class RequestListener
	implements ServletRequestListener , ServletRequestAttributeListener
{
	// ���û����󵽴����ʼ��ʱ�����÷���
	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		System.out.println("----����" + request.getRequestURI()
			+ "���󱻳�ʼ��----");	}
	// ���û����������������ʱ�����÷���
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		System.out.println("----����" + request.getRequestURI()
			+ "��������----");
	}
	// ��������request��Χ�������ʱ�����÷���
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event)
	{
		ServletRequest request = event.getServletRequest();
		// ��ȡ��ӵ�������������ֵ
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(request + "��Χ���������Ϊ"
			+ name + "��ֵΪ" + value + "������!");
	}
	// �������request��Χɾ������ʱ�����÷���
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event)
	{
		ServletRequest request = event.getServletRequest();
		// ��ȡ��ɾ����������������ֵ
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(request + "��Χ����Ϊ"
			+ name + "��ֵΪ" + value + "�����Ա�ɾ����!");
	}
	// ��request��Χ�����Ա��滻ʱ�����÷���
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event)
	{
		ServletRequest request = event.getServletRequest();
		// ��ȡ���滻��������������ֵ
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(request + "��Χ����Ϊ"
			+ name + "��ֵΪ" + value + "�����Ա��滻��!");
	}
}
