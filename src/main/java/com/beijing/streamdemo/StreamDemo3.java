package com.beijing.streamdemo;

import java.util.ArrayList;

/**
 * [Stream<T>filter(Predicate predicate):用于对流中的数据进行过滤
 * Predicate接口中的方法boolean test(Tt):对给定的参数进行判断，返回一个布尔值]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王宝强");
        list.add("柳岩");
        list.add("张敏");
        list.add("张三丰");

        //需求1：把List集合中以张开头的元素在控制台输出
        System.out.println("需求1：把List集合中以张开头的元素在控制台输出:");
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);

        //需求2：把List集合中长度为的元素在控制台输出
        System.out.println("需求2：把List集合中长度为的元素在控制台输出:");
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);

        //需求3：把List集合中以张开头的，长度为的元素在控制台输出
        System.out.println("需求3：把List集合中以张开头的，长度为的元素在控制台输出:");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
