package com.itheima_01.web.servlet;

import com.itheima_01.mapper.UserMapper1;
import com.itheima_01.pojo.User;
import com.itheima_01.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * [LoginServlet]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/6 10:19]
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用MyBat1s完成查询
        //2.1获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2获取SqlSession.对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3获取Mapper
        UserMapper1 userMapper1 = sqlSession.getMapper(UserMapper1.class);

        //2.4调用方法
        User user = userMapper1.select(username, password);

        //2.5释放资源
        sqlSession.close();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //3.判断User是否为null
        if (user != null) {
            //登录成功
            writer.write("登录成功！");
        }else {
            //登录失败
            writer.write("登录失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}
