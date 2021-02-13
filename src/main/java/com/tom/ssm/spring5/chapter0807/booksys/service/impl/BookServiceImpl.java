package com.tom.ssm.spring5.chapter0807.booksys.service.impl;

import com.tom.ssm.spring5.chapter0807.booksys.dao.BookDao;
import com.tom.ssm.spring5.chapter0807.booksys.domain.Book;
import com.tom.ssm.spring5.chapter0807.booksys.service.BookService;

import java.util.List;


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
public class BookServiceImpl implements BookService
{
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	@Override
	public int addBook(Book book)
	{
		return (Integer) bookDao.save(book);
	}

	@Override
	public List<Book> getAllBooks()
	{
		return bookDao.findAll(Book.class);
	}

	@Override
	public void deleteBook(int id)
	{
		bookDao.delete(Book.class, id);
	}
}
