package com.beijing.work7_1.tcpdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * [TCP发送数据的步骤
 * 1:创建客户端的Socket对象(Socket)
 * 2:获取输出流，写数据
 * 3:释放资源]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:34]
 */
class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1:创建客户端的Socket对象(Socket)
        /*
        //Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号
        Socket s = new Socket(InetAddress.getByName("192.168.95.122"), 10086);
        */


        //Socket(String host, int port) 创建流套接字并将其连接到命名主机上的指定端口号
        Socket socket = new Socket("192.168.95.122", 10086);

        //2:获取输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("Hello,TPC!".getBytes());

        //3:释放资源
        socket.close();
    }
}
