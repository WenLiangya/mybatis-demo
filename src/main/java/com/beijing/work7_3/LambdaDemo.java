package com.beijing.work7_3;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 15:17]
 * @noinspection AlibabaAvoidManuallyCreateThread
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //实现类的方式实现需求
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //匿名内部类的方式改进
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程程序启动了..");
            }
        }).start();

        //Lambda表达式的方式改进
        new Thread(() -> {
            System.out.println("多线程程序启动了..");
        }).start();
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("多线程程序启动了..");
    }
}