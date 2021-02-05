package com.tom.ssm.servelet.chapter0208;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.sql.*;
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
public class IteratorTag extends SimpleTagSupport
{
	// ��ǩ���ԣ�����ָ����Ҫ�������ļ���
	private String collection;
	// ��ǩ���ԣ�ָ����������Ԫ�أ�Ϊ����Ԫ��ָ��������
	private String item;

	// collection��setter��getter����
	public void setCollection(String collection)
	{
		this.collection = collection;
	}
	public String getCollection()
	{
		return this.collection;
	}
	// item��setter��getter����
	public void setItem(String item)
	{
		this.item = item;
	}
	public String getItem()
	{
		return this.item;
	}
	// ��ǩ�Ĵ���������ǩ������ֻ��Ҫ��дdoTag()����
	@Override
	public void doTag() throws JspException, IOException
	{
		// ��page scope�л�ȡ��Ϊcollection�ļ���
		Collection itemList = (Collection)getJspContext().
			getAttribute(collection);
		// ��������
		for (Object s : itemList)
		{
			// �����ϵ�Ԫ�����õ�page��Χ��
			getJspContext().setAttribute(item, s );
			// �����ǩ��
			getJspBody().invoke(null);
		}
	}
}