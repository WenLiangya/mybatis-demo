package com.beijing.work7_1.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * [UDP接收数据的步骤
 * 1:创建接收端的Socket:对象(DatagramSocket)
 * 2:创建一个数据包，用于接收数据
 * 3:调用DatagramSocket对象的方法接收数据
 * 4:解析数据包，并把数据在控制台显示
 * 5:关闭接收端]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 16:52]
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //1:创建接收端的Socket:对象(DatagramSocket)
        //DatagramSocket() 构造一个数据报套接字，并将其绑定到本地主机上的指定端口
        DatagramSocket ds = new DatagramSocket(10086);

        //2:创建一个数据包，用于接收数据
        //DatagramPacket(byte buf[], int length)  构造一个DatagramPacket用于接收长度为Length的数据包
        byte[] bytes = new byte[512];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        //3:调用DatagramSocket对象的方法接收数据
        ds.receive(dp);

        //4:解析数据包，并把数据在控制台显示
        //byte[] getData()  返回数据缓冲区
        byte[] data = dp.getData();
        //getLength() 返回要发送的数据或接收到的数据的长度
        //String(byte bytes[], int offset, int length)
        String dataString = new String(data, 0, dp.getLength());
        System.out.println("接收到数据：" + dataString);

//        System.out.println("接收到数据："+new String(dp.getData(), 0, dp.getLength()));

        //5:关闭接收端
        ds.close();
    }
}

class ReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        //1:创建接收端的Socket:对象(DatagramSocket)
        DatagramSocket datagramSocket = new DatagramSocket(10086);

        String str = null;
        while (!("886".equals(str))) {
            //2:创建一个数据包，用于接收数据
            byte[] bytes = new byte[512];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            //3:调用DatagramSocket对象的方法接收数据
            datagramSocket.receive(datagramPacket);

            str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

            //4:解析数据包，并把数据在控制台显示
            System.out.println("接收到数据：" + str);
        }

        //5:关闭接收端
        datagramSocket.close();
    }
}
