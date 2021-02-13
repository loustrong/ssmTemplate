package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

/**
 * OrderException
 *
 * @author Tom on 2021/2/12
 */
public class OrderException extends RuntimeException{
    public OrderException(){}
    public OrderException(Throwable cause){
        super(cause);
    }
    public OrderException(String message){
        super(message);
    }
    public OrderException(String message, Throwable cause){
        super(message, cause);
    }
    public OrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
