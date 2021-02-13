package com.tom.ssm.spring5.chapter0808.booksys.service.impl;

import java.util.List;

import com.tom.ssm.spring5.chapter0808.booksys.dao.BookDao;
import com.tom.ssm.spring5.chapter0808.booksys.domain.Book;
import com.tom.ssm.spring5.chapter0808.booksys.service.BookService;
import org.springframework.transaction.annotation.Transactional;


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
@Transactional
public class BookServiceImpl implements BookService
{
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}
	@Override
	public void addBook(Book book)
	{
		bookDao.save(book);
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
