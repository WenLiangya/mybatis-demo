package com.beijing.work7_1.tcpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * [客户端：发送数据，接收服务器反馈]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:34]
 */
class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        //1:创建客户端的Socket对象(Socket)
        //Socket(String host, int port) 创建流套接字并将其连接到命名主机上的指定端口号
        Socket socket = new Socket("192.168.95.122", 10086);

        //2:获取输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("Hello,TPC!".getBytes());

        //3:接收服务器反馈
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[512];
        System.out.println("客户端：" + new String(bytes, 0, is.read(bytes)));

        //4:释放资源
        socket.close();
    }
}
