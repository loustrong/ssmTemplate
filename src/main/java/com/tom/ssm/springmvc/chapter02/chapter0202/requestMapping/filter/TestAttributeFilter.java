package com.tom.ssm.springmvc.chapter02.chapter0202.requestMapping.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * TestAttributeFilter
 *
 * @author Tom on 2021/2/11
 */
// 过滤器拦截请求
    @WebFilter("/requestMappingUser/main")
public class TestAttributeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入AuthFilter过滤器的doFilter方法");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setAttribute("school", "疯狂软件");
        request.getSession().setAttribute("author", "Tom");
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy.");
    }
}
