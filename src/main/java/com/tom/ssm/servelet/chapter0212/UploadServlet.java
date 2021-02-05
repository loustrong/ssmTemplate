package com.tom.ssm.servelet.chapter0212;

/**
 * @descriptions: UploadServlet
 * @author: Tom
 * @date: 2021/2/4 下午 10:43
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name="upload", urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("GBK");
        String name = request.getParameter("name");
        out.print("普通的name參數為:" + name + "<br/>");
        Part part = request.getPart("file");
        // 獲取上傳文件的文件類型
        out.println("上傳文件的類型為:" + part.getContentType() + "<br/>");
        out.println("上傳文件的大小為:" + part.getSize() + "<br/>");
        Collection<String> headNames = part.getHeaderNames();
        // 遍歷文件上傳域的Head Name, Value
        for(String headerName: headNames){
            out.println(headerName + "--->" + part.getHeader(headerName) + "<br/>");
        }

        String fileNameInfo = part.getHeader("content-disposition");
        String fileName = fileNameInfo.substring(
                fileNameInfo.indexOf("filename=\'") + 10, fileNameInfo.length() - 1
        );
        part.write(getServletContext().getRealPath("/uploadFiles") + "/" + fileName);

    }
}
