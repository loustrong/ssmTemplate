package com.tom.ssm.spring5.chapter0802.autowired.service;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;



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
public interface BaseService<T>
{
	void addEntity(T entity);
}