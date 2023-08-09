package com.beijing.work7_1.tcpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [服务器：接收数据，给出反馈]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:45]
 */
class ServerDemo1 {
    /**
     * @noinspection AlibabaRemoveCommentedCode
     */
    public static void main(String[] args) throws IOException {
        //1:创建服务器端的Socket:对象(ServerSocket)
        ServerSocket ss = new ServerSocket(10086);

        //Socket accept() 侦听要连接到此套接字并接受它
        Socket s = ss.accept();

        //2:获取输入流，读数据，并把数据显示在控制台
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[512];
        //read() 从输入流中读取一定数量的字节，并将其存储到缓冲区数组b中。实际读取的字节数以整数形式返回
//        int len = is.read(bytes);
        System.out.println("服务器：" + new String(bytes, 0, is.read(bytes)));

        //3:给出反馈
        OutputStream os = s.getOutputStream();
        os.write("数据已接收！".getBytes());

        //4:释放资源
//        s.close();  //s可以不单独释放，s基于ss，释放ss即可
        ss.close();
    }
}
