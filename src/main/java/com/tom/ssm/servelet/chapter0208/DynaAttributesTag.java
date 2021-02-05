package com.tom.ssm.servelet.chapter0208;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
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
public class DynaAttributesTag
	extends SimpleTagSupport implements DynamicAttributes
{
	// ����ÿ���������ļ���
	private ArrayList<String> keys = new ArrayList<String>();
	// ����ÿ������ֵ�ļ���
	private ArrayList<Object> values = new ArrayList<Object>();

	@Override
	public void doTag() throws JspException, IOException
	{
		JspWriter out = getJspContext().getOut();
		// �˴�ֻ�Ǽ򵥵����ÿ������
		out.println("<ol>");
		for( int i = 0; i < keys.size(); i++ )
		{
			String key = keys.get( i );
			Object value = values.get( i );
			out.println( "<li>" + key + " = " + value + "</li>" );
		}
		out.println("</ol>");
	}

	@Override
	public void setDynamicAttribute( String uri, String localName,
		Object value )throws JspException
	{
		// ���������
		keys.add( localName );
		// �������ֵ
		values.add( value );
	}
}