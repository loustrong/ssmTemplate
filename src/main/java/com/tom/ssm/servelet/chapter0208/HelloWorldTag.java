package com.tom.ssm.servelet.chapter0208;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @descriptions: HelloWorldTag
 * @author: Tom
 * @date: 2021/2/4 下午 03:34
 * @version: 1.0
 */
public class HelloWorldTag extends SimpleTagSupport
{
    // 重写doTag()方法，该方法为标签生成页面内容
    @Override
    public void doTag()throws JspException,
            IOException
    {
        // 获取页面输出流，并输出字符串
        getJspContext().getOut().write("Hello World "
                + new java.util.Date());
    }
}
