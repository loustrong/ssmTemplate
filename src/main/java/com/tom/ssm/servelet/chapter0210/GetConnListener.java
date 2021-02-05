package com.tom.ssm.servelet.chapter0210;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @descriptions: GetConnectListener
 * @author: Tom
 * @date: 2021/2/4 ÏÂÎç 07:35
 * @version: 1.0
 */
public class GetConnListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            ServletContext application = servletContextEvent.getServletContext();
            String driver = application.getInitParameter("driver");
            String url = application.getInitParameter("url");
            String user = application.getInitParameter("user");
            String pass = application.getInitParameter("pass");
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            application.setAttribute("conn", conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        System.out.println(conn);
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
