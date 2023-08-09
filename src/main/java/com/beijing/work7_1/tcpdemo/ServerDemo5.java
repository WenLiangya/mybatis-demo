package com.beijing.work7_1.tcpdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [服务器：接收到的数据写入文本文件，给出反馈]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:45]
 */
class ServerDemo5 {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        //创建服务器端的Socket:对象(ServerSocket)
        ServerSocket ss = new ServerSocket(10086);

        //监听客户端连接，返回一个对应的Socket对象
        Socket s = ss.accept();

        //接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/BeiJing/network/tcpDemo/ServerDemo5_1.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("文件上传成功！");
        bwServer.newLine();
        bwServer.flush();

        //3:释放资源
        bw.close();
        ss.close();
    }
}
