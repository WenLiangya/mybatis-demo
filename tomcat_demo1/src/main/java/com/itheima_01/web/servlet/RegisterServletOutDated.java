package com.itheima_01.web.servlet;

import com.itheima_01.mapper.UserMapper1;
import com.itheima_01.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * [1.代码重复：工具类
 * 2.SqlSessionFactasy工厂只创建一次，不要重复创建：静态代码块]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/6 11:28]
 */
@WebServlet("/registeroutdated")
public class RegisterServletOutDated extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mapper 根据用户名查询用户对象
        //2.1获取SqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取mapper
        UserMapper1 userMapper1 = sqlSession.getMapper(UserMapper1.class);
        //2.4调用方法
        User userByName = userMapper1.selectByName(username);

        //3.判断用户是否存在
        if(userByName == null) {
            //用户不存在，添加对象
            userMapper1.add(user);
            response.getWriter().write("注册成功！");
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        }else {
            //用户存在，给出提示
            response.setContentType("text/html; charset=UTF-8");
/*
            PrintWriter writer = response.getWriter();
            writer.write("用户名已存在！");
*/
            response.getWriter().write("用户名已存在！");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
