package com.tom.ssm.servelet.chapter0210;

import javax.servlet.*;
import javax.servlet.annotation.*;/**
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
public class MyServletContextAttributeListener
	implements ServletContextAttributeListener
{
	// 當程序向application範圍添加屬性,則調用該方法
	@Override
	public void attributeAdded(ServletContextAttributeEvent event)
	{
		ServletContext application = event.getServletContext();
		// 獲取添加的屬性和屬性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(application + "範圍內添加了屬性值, 屬性名為:"
			+ name + "屬性值為:" + value + "的屬性!");
	}
	// 當程序向application範圍移除屬性,則調用該方法
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event)
	{
		ServletContext application = event.getServletContext();
		// 獲取移除的屬性和屬性值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(application + "��Χ����Ϊ"
			+ name + "��ֵΪ" + value + "�����Ա�ɾ����!");
	}
	// 當程序向application範圍替換屬性,則調用該方法
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event)
	{
		ServletContext application = event.getServletContext();
		// 獲取替換屬性的名稱和數值
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(application + "��Χ����Ϊ"
			+ name + "��ֵΪ" + value + "�����Ա��滻��!");
	}
}
