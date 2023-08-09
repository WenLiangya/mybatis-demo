package com.beijing.work7_1.tcpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [服务器：接收到的数据在控制台输出]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:45]
 */
class ServerDemo2 {
    /**
     * @noinspection AlibabaRemoveCommentedCode
     */
    public static void main(String[] args) throws IOException {
        //1:创建服务器端的Socket:对象(ServerSocket)
        ServerSocket ss = new ServerSocket(10086);

        //Socket accept() 侦听要连接到此套接字并接受它
        Socket s = ss.accept();

        //2:获取输入流，读数据，并把数据显示在控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        //3:释放资源
//        s.close();  //s可以不单独释放，s基于ss，释放ss即可
        ss.close();
    }
}
