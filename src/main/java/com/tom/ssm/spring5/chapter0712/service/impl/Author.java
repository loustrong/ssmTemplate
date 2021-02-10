package com.tom.ssm.spring5.chapter0712.service.impl;

import java.util.*;

import com.tom.ssm.spring5.chapter0712.service.Axe;
import com.tom.ssm.spring5.chapter0712.service.Person;
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
public class Author implements Person
{
	private Integer id;
	private String name;
	private List<String> books;
	private Axe axe;
	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public String getName()
	{
		return this.name;
	}

	// books��setter��getter����
	public void setBooks(List<String> books)
	{
		this.books = books;
	}
	@Override
	public List<String> getBooks()
	{
		return this.books;
	}

	// axe��setter����
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}

	@Override
	public void useAxe()
	{
		System.out.println("����"
			+ name + "�����ڿ���\n" + axe.chop());
	}
}