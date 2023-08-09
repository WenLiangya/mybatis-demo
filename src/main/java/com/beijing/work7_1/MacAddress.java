package com.beijing.work7_1;

import java.io.*;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 16:06]
 */
public class MacAddress {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Operating System " + getOsName());
        System.out.println("Mac Address = " + getMacAddress());
/*
        System.out.println("通过ip获取mac地址为:" + getMACAddress("192.168.51.113"));
        long end = System.currentTimeMillis();
        System.out.println("获取电脑MAC地址时间为:" + (end - start));
*/
    }

    /**
     * 获得MAC地址
     */
    public static String getMacAddress() {
        String address = "";
        String os = getOsName();
        System.out.println("+++++++++++");
        //根据操作系统类型获取MAC地址
        if (os.startsWith("Windows")) {
            try {
                String command = "cmd.exe /c ipconfig /all";
                Process p = Runtime.getRuntime().exec(command);
                //转换成字节文件
                InputStream in = p.getInputStream();
                //字节转换成字符文件
                Reader reader = new InputStreamReader(in, "gbk");
                BufferedReader br = new BufferedReader(reader);
                String line;
                boolean flag = false;
                while ((line = br.readLine()) != null) {
                    if (line.indexOf("无线局域网适配器") > 0) {
                        flag = true;
                        continue;
                    }
                    if (flag) {
                        if (line.indexOf("物理地址") > 0) {
                            System.out.println(line);
                            int index = line.indexOf(":");
                            index += 2;
                            address = line.substring(index);
                            break;
                        }
                    }

                }
                br.close();
                return address.trim();
            } catch (IOException e) {
            }
        } else if (os.startsWith("Linux")) {
            String command = "/bin/sh -c ifconfig -a";
            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.indexOf("HWaddr") > 0) {
                        int index = line.indexOf("HWaddr") + "HWaddr".length();
                        address = line.substring(index);
                        break;
                    }
                }
                br.close();
            } catch (IOException e) {
            }
        }
        address = address.trim();
        return address;
    }


    /**
     * 获得操作系统名称
     */
    public static String getOsName() {
        //获得系统的所有参数
        //getProperties() 确定当前系统属性
        System.out.println(System.getProperties());
        System.out.println("-------------------------");
        String os = System.getProperty("os.name");
        return os;
    }

    /**
     * 根据IP地址获取MAC地址
     */
    public static String getMACAddress(String ipAddress) {
        String str = "", strMAC = "", macAddress = "";
        try {
            Process pp = Runtime.getRuntime().exec("nbtstat -a " + ipAddress);
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        strMAC = str.substring(str.indexOf("MAC Address") + 14);
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            return "Can't Get MAC Address!";
        }
        if (strMAC.length() < 17) {
            return "Error!";
        }
        macAddress = strMAC.substring(0, 2) + ":" + strMAC.substring(3, 5) + ":" + strMAC.substring(6, 8) + ":" + strMAC.substring(9, 11) + ":"
                + strMAC.substring(12, 14) + ":" + strMAC.substring(15, 17);
        return macAddress;
    }
}
