package com.beijing.streamdemo;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * [static<T>Stream<T>concat(Stream a,Stream b):合并a和b两个流为一个流
 * Stream<T>distinct(0:返回由该流的不同元素（根据Dbjectequals(Object))组成的流]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王宝强");
        list.add("柳岩");
        list.add("张敏");
        list.add("张三丰");

        //需求1：取前4个数据组成一个流
        Stream<String> s1 = list.stream().limit(4);

        //需求2：跳过2个数据组成一个流
        Stream<String> s2 = list.stream().skip(2);

        //需求3：合并需求1和需求2得到的流，并把结果在控制台输出
        System.out.println("需求3：合并需求1和需求2得到的流，并把结果在控制台输出:");
//        Stream.concat(s1,s2).forEach(System.out::println);

        //需求4：合并需求1和需求2得到的流，并把结果在控制台输出，要求字符串元素不能重复
        System.out.println("需求4：合并需求1和需求2得到的流，并把结果在控制台输出，要求字符串元素不能重复:");
        Stream.concat(s1,s2).distinct().forEach(System.out::println);

    }
}
