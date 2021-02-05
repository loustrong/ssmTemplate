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
 * @date: 2021/2/4 ���� 11:21
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/async13", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        out.println("<title>������IOʾ��</title>");
        out.println("�M��Servlet�ĕr�g:"
        + new Date() + ".<br/>");
        AsyncContext context = request.startAsync();
        context.setTimeout(60 * 1000);
        ServletInputStream input = request.getInputStream();
        // ��ݔ�����]�ԱO ��
        input.setReadListener(new MyReadListener(input, context));
        out.println("�Y��Servlet�ĕr�g:" + new Date() + ".<br/>");
        out.flush();
    }
}
