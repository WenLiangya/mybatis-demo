package com.itheima_01.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * [响应字节数据：设置字节数据的响应体]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/5 21:00]
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    /** @noinspection AlibabaRemoveCommentedCode*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.读取文件
        FileInputStream fileInputStream = new FileInputStream("D:\\develop\\WorkSpace\\mybatis-demo\\tomcat_demo1\\src\\main\\resources\\a.webp");
        //2.获取response字节输出流
        ServletOutputStream os = response.getOutputStream();
        /*
            3.完成流的copy
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        */
        //org.apache.commons.io public class IOUtils
        //extends Object
        IOUtils.copy(fileInputStream,os);

        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
