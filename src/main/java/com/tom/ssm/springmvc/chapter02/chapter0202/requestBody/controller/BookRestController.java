package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * BookRestController
 *
 * @author Tom on 2021/2/12
 */
@RestController
@RequestMapping("/jsonRest")
public class BookRestController {

    @RequestMapping(value="/testRequestBody")
    public Object getJson(){
        List<Book> list = new ArrayList<>();
        list.add(new Book(1, "Spring+Mybatis企业应用实战", "刘强"));
        list.add(new Book(2, "轻量级JavaEE企业应用实战", "李刚"));
        return list;
    }


}
