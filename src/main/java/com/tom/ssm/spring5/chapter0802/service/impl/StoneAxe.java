package com.tom.ssm.spring5.chapter0802.service.impl;

import com.tom.ssm.spring5.chapter0802.service.Axe;
import org.springframework.stereotype.*;

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
@Component
public class StoneAxe implements Axe
{
	@Override
	public String chop()
	{
		return "ʯ���������";
	}
}