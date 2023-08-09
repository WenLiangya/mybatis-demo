package com.itheima_01.servletdemo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @version : [v1.0]
 * @createTime : [2023/6/7 19:25]
 * @updateUser : [Jiu Meng]
 * @updateTime : [2023/6/7 19:25]
 */
public class MyHttpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //根据请求方式的不同，进行分别的处理
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1.获取请求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            doGet(servletRequest,servletResponse);
        }else if("POST".equals(method)){
            doPost(servletRequest,servletResponse);
        }
    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    protected void doGet(ServletRequest request,ServletResponse response) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()...");
    }
}
