package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain.Book;
import com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain.BookException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * BookController
 *
 * @author Tom on 2021/2/11
 */
@Controller
@RequestMapping("/json")
public class BookController {
    @RequestMapping(value="/testRequestBody")
    public void setJson(
            @RequestBody Book book,
            HttpServletResponse response
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(book));
        book.setAuthor("Tom");
        response.setContentType("text/html;charset=UTF-8");
        //将book对象转换成json写出到客户端
        response.getWriter().println(mapper.writeValueAsString(book));
    }

    @RequestMapping(value="/index")
    public String index() throws IOException {

        return "0302/model/requestBodyIndex";
    }


    @RequestMapping(value="/exceptionIndex")
    public String indexException() throws IOException {

        return "0302/model/exceptionIndex";
    }


    @GetMapping("/hello")
    public String hello() throws Exception{
        // 抛出异常
        throw new Exception();
    }

    @GetMapping("/test")
    public String test() throws Exception{
        try{
            // 模拟异常
            int i = 5/0;
            return "success";
        }catch(Exception e){
            throw new BookException();
        }

    }

    @GetMapping("/find")
    public String find() throws Exception{
        try {
            // 模拟异常
            int i = 5/0;
            return "success";
        } catch (Exception e) {
            throw new SQLException("查找数据失败!");
        }
    }

}
