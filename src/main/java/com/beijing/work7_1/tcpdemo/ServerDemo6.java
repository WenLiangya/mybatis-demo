package com.beijing.work7_1.tcpdemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [服务器：接收到的数据写入文本文件，给出反馈，
 * 代码用线程进行封装，为每一个客户端开启一个线程]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:45]
 */
class ServerDemo6 {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        //创建服务器端的Socket:对象(ServerSocket)
        ServerSocket ss = new ServerSocket(10086);

        while (true) {
            //监听客户端连接，返回一个对应的Socket对象
            Socket s = ss.accept();

            new Thread(new ServerThead6(s)).start();
        }
    }
}
