package com.tom.ssm.servelet.chapter0207;

import java.sql.*;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

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
@WebServlet(name="testServlet"
	, urlPatterns={"/testServlet"}
	, initParams={
		@WebInitParam(name="driver", value="com.mysql.jdbc.Driver"),
		@WebInitParam(name="url", value="jdbc:mysql://localhost:3306/javaee"),
		@WebInitParam(name="user", value="root"),
		@WebInitParam(name="pass", value="32147")})
public class TestServlet extends HttpServlet
{
	// ��дinit����
	public void init(ServletConfig config)
		throws ServletException
	{
		// ��д�÷�����Ӧ�����ȵ��ø����init()����
		super.init(config);
	}
	// ��Ӧ�ͻ�������ķ���
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
	{
		try
		{
			// ��ȡServletConfig����
			ServletConfig config = getServletConfig();
			// ͨ��ServletConfig�����ȡ���ò�����dirver
			String driver = config.getInitParameter("driver");
			// ͨ��ServletConfig�����ȡ���ò�����url
			String url = config.getInitParameter("url");
			// ͨ��ServletConfig�����ȡ���ò�����user
			String user = config.getInitParameter("user");
			// ͨ��ServletConfig�����ȡ���ò�����pass
			String pass = config.getInitParameter("pass");
			// ע������
			Class.forName(driver);
			// ��ȡ���ݿ�����
			Connection conn = DriverManager.getConnection(url,user,pass);
			// ����Statement����
			Statement stmt = conn.createStatement();
			// ִ�в�ѯ����ȡResuletSet����
			ResultSet rs = stmt.executeQuery("select * from news_inf");
			response.setContentType("text/html;charSet=gbk");
			// ��ȡҳ�������
			PrintStream out = new PrintStream(response.getOutputStream());
			// ���HTML��ǩ
			out.println("<html>");
			out.println("<head>");
			out.println("<title>����Servlet��ʼ����������</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table bgcolor=\"#9999dd\" border=\"1\"" +
				"width=\"480\">");
			// ���������
			while(rs.next())
			{
				// ������������
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
