package com.itheima_01.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/5 9:55]
 */
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String getMethod():获取请求方式：GET
        String method = req.getMethod();
        System.out.println("method:" + method);
        //String getContextPath():获取虚拟目录（项目访问路径）：/request-demo
        String contextPath = req.getContextPath();
        System.out.println("contextPath:" + contextPath);
        //StringBuffer getRequestURL():获取URL(统一资源定位符)：http:L/Localhost:8080/request-demo/req.1
        StringBuffer url = req.getRequestURL();
        System.out.println("requestURL:" + url);
        //String getRequestURI():获取URI(统一资源标识符)：/request-demo/req1
        String uri = req.getRequestURI();
        System.out.println("uri:" + uri);
        //string getQuerystring():获取请求参数(GET方式)：username=zhangsan
        String queryString = req.getQueryString();
        System.out.println("queryString:" + queryString);

        //获取请求头：User-agent:浏览器的版本信息
        String header = req.getHeader("User-Agent");
        System.out.println("header:" + header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体：请求参数

        //1.获取字符输入流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
