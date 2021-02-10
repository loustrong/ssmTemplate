package com.tom.ssm.spring5.chapter0802.autowired.service.impl;

import com.tom.ssm.spring5.chapter0802.autowired.domain.Item;
import com.tom.ssm.spring5.chapter0802.autowired.service.ItemService;
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
@Component("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item>
	implements ItemService
{
}