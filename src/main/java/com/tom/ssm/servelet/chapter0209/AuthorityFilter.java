package com.tom.ssm.servelet.chapter0209;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @descriptions: AuthorityFilter
 * @author: Tom
 * @date: 2021/2/4 下午 05:42
 * @version: 1.0
 */
@WebFilter(
//        filterName = "authority",
//        urlPatterns = {"/*"},
//        initParams = {
//                @WebInitParam(name="encoding", value="UTF-8"),
//                @WebInitParam(name="loginPage", value="/login.jsp"),
//                @WebInitParam(name="proLogin", value="/proLogin.jsp")
//        }
)
public class AuthorityFilter implements Filter {

    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = config.getInitParameter("encoding");
        String loginPage = config.getInitParameter("loginPage");
        String proLogin = config.getInitParameter("proLogin");
        servletRequest.setCharacterEncoding(encoding);
        HttpServletRequest requ = (HttpServletRequest) servletRequest;
        HttpSession session = requ.getSession(true);
        String requestPath = requ.getServletPath();
        // 如果session範圍的user為null, 即表明未登錄
        // 且用戶請求的既不是登錄頁面,也不是處理登錄的頁面
//        if(session.getAttribute("user") == null
//        && !requestPath.endsWith(loginPage)
//        && !requestPath.endsWith(proLogin)){
//            servletRequest.setAttribute("tip", "您還沒有登錄");
//            servletRequest.getRequestDispatcher(loginPage).forward(servletRequest,servletResponse);
//        } else {
            filterChain.doFilter(servletRequest,servletResponse);
//        }

    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
