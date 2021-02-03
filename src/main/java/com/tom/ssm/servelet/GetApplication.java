package com.tom.ssm.servelet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * GetApplication
 *
 * @author Tom on 2021/2/3
 */
@WebServlet( name="get-application",
        urlPatterns={"/get-application"}
)
public class GetApplication extends HttpServlet {
    public void service(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>");
        out.println("测试application");
        out.println("</title></head><body>");
        ServletContext sc = getServletConfig().getServletContext();
        out.println("application中当前的counter值为:");
        out.println(sc.getAttribute("counter"));
        out.println("</body></html>");
    }
}
