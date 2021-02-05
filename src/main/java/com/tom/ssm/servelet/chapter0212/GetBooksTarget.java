package com.tom.ssm.servelet.chapter0212;


import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @descriptions: Executor
 * @author: Tom
 * @date: 2021/2/4 下午 08:39
 * @version: 1.0
 */
public class GetBooksTarget implements Runnable {

    private AsyncContext actx = null;

    public GetBooksTarget(AsyncContext actx) {
        this.actx = actx;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5 * 1000);
            ServletRequest request = actx.getRequest();
            List<String> books = new ArrayList<String>();
            books.add("瘋狂Java講義");
            books.add("輕量級Java EE企業應用實戰");
            books.add("瘋狂前端開發講義");
            request.setAttribute("books",books);
            actx.dispatch("/crazyit/chapter02/chapter0212/async.jsp");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
