package com.itheima_01.web.servlet;

import com.itheima_01.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/6 17:12]
 */
@WebServlet("/jspdemo1")
public class JspServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.准备数据
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠公司",100,"三只松鼠零食",1));
        brands.add(new Brand(2,"优衣库","优衣库公司",200,"优衣库服装",0));
        brands.add(new Brand(3,"小米","小米公司",1000,"小米手机",1));

        //2.存储到request域中
        request.setAttribute("brands",brands);

        //3.转发到el-demo1.jsp
        request.getRequestDispatcher("/el-demo1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
