package com.tom.ssm.servelet.chapter0208;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
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
public class QueryTag extends SimpleTagSupport
{
	// �����Ա�����������ǩ������
	private String driver;
	private String url;
	private String user;
	private String pass;
	private String sql;

	// driver��setter��getter����
	public void setDriver(String driver)
	{
		this.driver = driver;
	}
	public String getDriver()
	{
		return this.driver;
	}

	// url��setter��getter����
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}

	// user��setter��getter����
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}

	// pass��setter��getter����
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// sql��setter��getter����
	public void setSql(String sql)
	{
		this.sql = sql;
	}
	public String getSql()
	{
		return this.sql;
	}

	// conn��setter��getter����
	public void setConn(Connection conn)
	{
		this.conn = conn;
	}
	public Connection getConn()
	{
		return this.conn;
	}

	// stmt��setter��getter����
	public void setStmt(Statement stmt)
	{
		this.stmt = stmt;
	}
	public Statement getStmt()
	{
		return this.stmt;
	}

	// rs��setter��getter����
	public void setRs(ResultSet rs)
	{
		this.rs = rs;
	}
	public ResultSet getRs()
	{
		return this.rs;
	}

	// rsmd��setter��getter����
	public void setRsmd(ResultSetMetaData rsmd)
	{
		this.rsmd = rsmd;
	}
	public ResultSetMetaData getRsmd()
	{
		return this.rsmd;
	}
	// ִ�����ݿ���ʵĶ���
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private ResultSetMetaData rsmd = null;
	@Override
	public void doTag()throws JspException,
		IOException
	{
	   	try
		{
			// ע������
			Class.forName(driver);
			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(url,user,pass);
			// ����Statement����
			stmt = conn.createStatement();
			// ִ�в�ѯ
			rs = stmt.executeQuery(sql);
			rsmd = rs.getMetaData();
			// ��ȡ����Ŀ
			int columnCount = rsmd.getColumnCount();
			// ��ȡҳ�������
			Writer out = getJspContext().getOut();
			// ��ҳ��������
			out.write("<table border='1' bgColor='#9999cc' width='400'>");
			// ���������
			while (rs.next())
			{
				out.write("<tr>");
				// ���������ѯ��������
				for (int i = 1 ; i <= columnCount ; i++ )
				{
					out.write("<td>");
					out.write(rs.getString(i));
					out.write("</td>");
				}
				out.write("</tr>");
			}
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
			throw new JspException("�Զ����ǩ����" + cnfe.getMessage());
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			throw new JspException("�Զ����ǩ����" + ex.getMessage());
		}
		finally
		{
			// �رս����
			try
			{
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
	}
}