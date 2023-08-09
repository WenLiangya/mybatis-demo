package com.beijing.work7_1.tcpdemo;

import java.io.*;
import java.net.Socket;

/**
 * [客户端：数据来自于文本文件，接收服务器反馈]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:34]
 */
class ClientDemo5 {
    public static void main(String[] args) throws IOException {
        //1:创建客户端的Socket对象(Socket)
        //Socket(String host, int port) 创建流套接字并将其连接到命名主机上的指定端口号
        Socket socket = new Socket("192.168.95.122", 10086);

        //2:封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/BeiJing/network/tcpDemo/ServerDemo5.txt"));
        //3:封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;

        while ((line = br.readLine()) != null) {
            if ("886".equals(line)) {
                bw.write(line);
                bw.newLine();
                bw.flush();
                break;
            }

            //获取输出流对象
            //写入字符串
            bw.write(line);
            bw.newLine();//写入行分隔符 换行
            bw.flush();//刷新流
        }

        //自定义结束标记
        // * bw.write("886");
        // * bw.newLine();
        // * bw.flush();

        //定义结束标记
        //shutdownOutput() 禁用此套接字的输出流
        socket.shutdownOutput();


        //接收反馈
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = reader.readLine();
        System.out.println("服务器反馈数据：" + data);

        //4:释放资源
        socket.close();
    }
}
