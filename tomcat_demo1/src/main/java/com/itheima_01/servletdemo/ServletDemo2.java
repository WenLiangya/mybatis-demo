package com.itheima_01.servletdemo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @version : [v1.0]
 * @createTime : [2023/5/29 14:40]
 * @updateUser : [Jiu Meng]
 * @updateTime : [2023/5/29 14:40]
 */
@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    private ServletConfig config;

    /**
     * 初始化方法
     * 1，调用时机：默认情况下，servlet被第一次访问时调用
     *      *LoadOnStartUp
     * 2，调用次数：1次
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("init()......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭的时候，ServLet对象会被销毁，调用
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy()......");
    }

    /**
     * 提供服务
     * 1.调用时机：每一次Servlet被访问时，调用
     * 2,调用次数：多次
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service: servlet hello~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
