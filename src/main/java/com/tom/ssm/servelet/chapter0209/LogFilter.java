package com.tom.ssm.servelet.chapter0209;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * @descriptions: LogFilter
 * @author: Tom
 * @date: 2021/2/4 下午 04:18
 * @version: 1.0
 */
@WebFilter(
        filterName = "log",
        urlPatterns = "/*"
)
public class LogFilter implements Filter {
    // FilterConfig可用於訪問Filter的配置信息
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter begins");
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // -- 下面代碼用於對客戶請求的預處理
        ServletContext context = this.config.getServletContext();
        long before = System.currentTimeMillis();
        System.out.println("開始過濾....");
        // 將請求轉換成HttpServletRequest請求
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        // 輸出提示訊息
        System.out.println("Filter已經截獲到用戶的請求地址:" + hrequest.getServletPath());
        // Filter只是鏈式處理,請求依然放行到目的地址
        filterChain.doFilter(servletRequest,servletResponse);
        long after = System.currentTimeMillis();
        // 輸出提示信息
        System.out.println("過濾結束");
        System.out.println("請求被定位到:" + hrequest.getRequestURI() +
                " 所花的時間是:" + (after - before));
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy.");
        this.config = null;
    }
}
