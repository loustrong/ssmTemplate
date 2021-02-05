package com.tom.ssm.servelet.chapter0213;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * @descriptions: MyReadListener
 * @author: Tom
 * @date: 2021/2/4 下午 11:32
 * @version: 1.0
 */
public class MyReadListener implements ReadListener {
    private ServletInputStream input;
    private AsyncContext context;
    public MyReadListener(ServletInputStream input,
                          AsyncContext context){
        this.input = input;
        this.context = context;
    }
    @Override
    public void onDataAvailable() throws IOException {
        System.out.println("數據可用!");
        try{
            Thread.sleep(5000);
            StringBuilder sb = new StringBuilder();
            int len = -1;
            byte[] buff = new byte[1024];
            while(input.isReady() && (len = input.read(buff))> 0){
                String data = new String(buff,0, len);
                sb.append(data);
            }
            System.out.println(sb);
            context.getRequest().setAttribute("info", sb.toString());
            // 轉發到視圖界面
            context.dispatch(context.getRequest().getServletContext().getContextPath()+ "crazyit/chapter02/chapter0212/async.jsp");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("數據讀取完成");
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
