package com.tom.ssm.servelet.chapter0212;

import javax.servlet.AsyncContext;
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
 * @date: 2021/2/4 下午 08:32
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<title>異步調用實例</title>");
        out.println("進入Servlet的時間是:" + new Date() + ".<br>");
        AsyncContext actx = request.startAsync();
        // 設置異步調用的超時時長
        actx.setTimeout(60 * 1000);
        actx.start(new GetBooksTarget(actx));
        out.println("結束的時間是:" + new Date() + ".<br/>");
        out.flush();
    }
}
