package com.tom.ssm.servelet.chapter0207;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.*;

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
@WebServlet(name="login"
	, urlPatterns={"/login"})
public class LoginServlet extends HttpServlet
{
	// ��Ӧ�ͻ�������ķ���
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
	{
		String errMsg = "";
		// Servlet�����������Ӧ���ͻ��ˣ���˱��뽫����ת������ͼҳ��
		RequestDispatcher rd;
		// ��ȡ�������
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		try
		{
			// Servlet������ִ���κε�ҵ���߼�����������JavaBean�����û�����
			DbDao dd = new DbDao("com.mysql.jdbc.Driver",
				"jdbc:mysql://10.62.240.45:3306/sakila","wcdmaria","wistron888");
			// ��ѯ�����
			ResultSet rs = dd.query("select pass from user_inf"
				+ " where name = ?", username);
			if (rs.next())
			{
				// �û���������ƥ��
				if (rs.getString("pass").equals(pass))
				{
					// ��ȡsession����
					HttpSession session = request.getSession(true);
					// ����session���ԣ������û��Ự״̬
					session.setAttribute("name" , username);
					// ��ȡת������
					rd = request.getRequestDispatcher("/crazyit/chapter02/chapter0207/welcome.jsp");
					// ת������
					rd.forward(request,response);
				}
				else
				{
					// �û��������벻ƥ��ʱ
					errMsg += "賬號密碼錯誤";
				}
			}
			else
			{
				// �û���������ʱ
				errMsg += "請輸入賬號和密碼!";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// �������ת�������µ�¼
		if (errMsg != null && !errMsg.equals(""))
		{
			rd = request.getRequestDispatcher("/crazyit/chapter02/chapter0207/login.jsp");
			request.setAttribute("err" , errMsg);
			rd.forward(request,response);
		}
	}
}
