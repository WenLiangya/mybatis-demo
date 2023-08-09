package com.beijing.work7_1.tcpdemo;

import java.io.*;
import java.net.Socket;

/**
 * [客户端：数据来自键盘录入，直到输入的数据是886，发送数据结束]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 20:34]
 */
class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        //1:创建客户端的Socket对象(Socket)
        //Socket(String host, int port) 创建流套接字并将其连接到命名主机上的指定端口号
        Socket socket = new Socket("192.168.95.122", 10086);

        //2:数据来自键盘录入，直到输入数据为886，发送数据结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        //4:释放资源
        socket.close();
    }
}
