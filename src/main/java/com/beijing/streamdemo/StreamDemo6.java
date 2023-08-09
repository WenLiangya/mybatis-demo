package com.beijing.streamdemo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * [Stream<T>sorted():返回由此流的元素组成的流，根据自然顺序排序
 * Stream<T>sorted(Comparator c):返回由该流的元素组成的流，根据提供的Comparator进行排序]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王宝强");
        list.add("柳岩");
        list.add("张敏");
        list.add("张三丰");

        //需求1：按照字母顺序把数据在控制台输出
        System.out.println("需求1：按照字母顺序把数据在控制台输出:");
        list.stream().sorted().forEach(System.out::println);

        //需求2：按照字符串长度把数据在控制台输出
        System.out.println("需求2：按照字符串长度把数据在控制台输出:");
//        list.stream().sorted((s1, s2) -> s1.length() - s2.length()).forEach(System.out::println);
        list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

//        list.stream().sorted((s1, s2) -> {
//            int num1 = s1.length() - s2.length();
//            int num2 = num1 == 0 ? s1.compareTo(s2) : num1;
//            return num2;
//        }).forEach(System.out::println);
    }
}
