package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BookException
 *
 * @author Tom on 2021/2/12
 */
@ResponseStatus(reason = "查询数据失败")
public class BookException extends RuntimeException{
}
