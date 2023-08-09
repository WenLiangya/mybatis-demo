package com.itheima_01.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * urlPattern:
 *    * 目录匹配：/user/*
 *
 * @author : [Jiu Meng]
 * @version : [v1.0]
 * @createTime : [2023/6/7 20:50]
 * @updateUser : [Jiu Meng]
 * @updateTime : [2023/6/7 20:50]
 */
@WebServlet(urlPatterns = "/user/*")
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo9 get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletDemo9 post...");
    }
}
