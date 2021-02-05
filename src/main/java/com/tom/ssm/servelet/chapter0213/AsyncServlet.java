package com.tom.ssm.servelet.chapter0213;

import javax.servlet.AsyncContext;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @descriptions: AsyncServlet
 * @author: Tom
 * @date: 2021/2/4 下午 11:21
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/async13", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        out.println("<title>非阻塞IO示例</title>");
        out.println("進入Servlet的時間:"
        + new Date() + ".<br/>");
        AsyncContext context = request.startAsync();
        context.setTimeout(60 * 1000);
        ServletInputStream input = request.getInputStream();
        // 為輸入流註冊監聽器
        input.setReadListener(new MyReadListener(input, context));
        out.println("結束Servlet的時間:" + new Date() + ".<br/>");
        out.flush();
    }
}
