package com.beijing.work7_1.tcpdemo;

import java.io.*;
import java.net.Socket;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 14:22]
 */
class ServerThead6 implements Runnable {
    private final Socket s;

    public ServerThead6(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            int count = 1;
            File file = new File("src/main/java/com/beijing/network/tcpdemo/ServerDemo6_" + count + ".txt");
            while (file.exists()) {
                count++;
                file = new File("src/main/java/com/beijing/network/tcpdemo/ServerDemo6_" + count + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

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

            //释放资源
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
