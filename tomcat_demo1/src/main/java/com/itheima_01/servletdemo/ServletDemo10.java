package com.itheima_01.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPattern:
 *    * 扩展名匹配： *.do
 *
 * @author : [Jiu Meng]
 * @version : [v1.0]
 * @createTime : [2023/6/7 20:50]
 * @updateUser : [Jiu Meng]
 * @updateTime : [2023/6/7 20:50]
 */
@WebServlet(urlPatterns = "*.do")
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo10 get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo10 post...");
    }
}
