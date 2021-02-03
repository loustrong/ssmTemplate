package com.tom.ssm.servelet.chapter0207;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * TimeServlet
 *
 * @author Tom on 2021/2/3
 */
@WebServlet(loadOnStartup = 1)
public class TimerServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Timer t = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());
            }
        });
         t.start();
    }

}
