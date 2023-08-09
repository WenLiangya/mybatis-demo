package com.beijing.work7_1.udpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * [UDP发送数据的步骤
 * 1:创建发送端的Socket对象(DatagramSocket)
 * 2:创建数据，并把数据打包
 * 3:调用DatagramSocket对象的方法发送数据
 * 4:关闭发送端]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 16:00]
 */
class SendDemo {
    public static void main(String[] args) throws IOException {
        //1:创建发送端的Socket对象(DatagramSocket)
        //DatagramSocket() 构造一个数据报套接字，并将其绑定到本地主机上的任何可用端口
        DatagramSocket datagramSocket = new DatagramSocket();

        //2:创建数据，并把数据打包
        byte[] bytes = "hello UDP!红红火火恍恍惚惚哈哈哈哈哈哈".getBytes();
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("192.168.95.122");
        //占用端口号
        int port = 10086;

        //DatagramPacket(bytes, length, address, port)
        //构造一个数据报数据包，用于将长度为的数据包发送到指定主机上的指定端口号。length参数必须小于或等于buf.length。
        //形参:
        //buf–数据包数据。
        //length–数据包长度。
        //address–目的地地址。
        //port–目标端口号
        DatagramPacket dp = new DatagramPacket(bytes, length, address, port);

        //3:调用DatagramSocket对象的方法发送数据
        //void send(DatagramPacket p) 从此套接字发送数据报数据包
        datagramSocket.send(dp);

        //4:关闭发送端
        //void close() 关闭此数据报套接字
        datagramSocket.close();
    }
}

/**
 * UDP发送数据：
 * 数据来自于键盘录入，直到输入的数据是886，发送数据结束
 */
class SendDemo1 {
    public static void main(String[] args) throws IOException {
        //1:创建发送端的Socket对象(DatagramSocket)
        DatagramSocket datagramSocket = new DatagramSocket();

        //自己封装键盘录入数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //输入的数据为886，发送数据结束
            if ("886".equals(line)) {
                //2:创建数据，并把数据打包
                byte[] bytes = line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("192.168.95.122"), 10086);

                //3:调用DatagramSocket对象的方法发送数据
                datagramSocket.send(datagramPacket);

                break;
            }

            //2:创建数据，并把数据打包
            byte[] bytes = line.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("192.168.95.122"), 10086);

            //3:调用DatagramSocket对象的方法发送数据
            datagramSocket.send(datagramPacket);
        }

        //4:关闭发送端
        datagramSocket.close();
    }
}