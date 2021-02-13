package com.tom.ssm.spring5.chapter0807.booksys.service;

import com.tom.ssm.spring5.chapter0807.booksys.domain.Book;

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
public interface BookService
{
	// ���ͼ��
	int addBook(Book book);

	List<Book> getAllBooks();

	void deleteBook(int id);
}
