package com.itheima_01.servletdemo;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @version : [v1.0]
 * @createTime : [2023/6/7 19:25]
 * @updateUser : [Jiu Meng]
 * @updateTime : [2023/6/7 19:25]
 */
@WebServlet(urlPatterns = "/demo5")
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post...");
    }

    @Override
    protected void doGet(ServletRequest request, ServletResponse response) {
        System.out.println("get...");
    }
}
