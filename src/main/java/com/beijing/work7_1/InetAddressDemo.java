package com.beijing.work7_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * [InetAddress类的使用]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 15:15]
 */
class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        test1();
        test2();
    }

    private static void test2() throws UnknownHostException {
        //检测异常ip
        //黑白红----办网    翻墙()
        //InetAddress address=InetAddress.getByName("LAPTOP-EIPRIDB0")
        InetAddress address = InetAddress.getByName("192.168.95.122");
        // 获取此 IP 地址的主机名
        System.out.println(address.getHostName());
//返回 IP 地址字符串（以文本表现形式）
        System.out.println(address.getHostAddress());
    }

    private static void test1() throws UnknownHostException {
        // InetAddress() {
        //        holder = new InetAddressHolder();
        //    }
        //默认的构造函数只能在同包下访问 ----
        //通过方法可以实现对象的创建

        //获得本机地址  在给定主机名称的情况下，确定主机的IP地址
        InetAddress address = InetAddress.getByName("192.168.95.122");

        //    public String getHostName()  获取此IP地址的主机名
        String name = address.getHostName();
        //    public String getHostAddress()  以文本形式返回IP地址字符串。
        String ip = address.getHostAddress();

        System.out.println("address：" + address);
        System.out.println("主机名：" + name);
        System.out.println("IP地址：" + ip);
    }
}
