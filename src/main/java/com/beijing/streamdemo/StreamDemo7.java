package com.beijing.streamdemo;

import java.util.ArrayList;

/**
 * [<R>Stream<R>map(Function mapper):返回由给定函数应用于此流的元素的结果组成的流
 * Function:接口中的方法  R apply(Tt)
 * IntStream mapTolnt(TolntFunction mapper):返回一个IntStream其中包含将给定函数应用于此流的元素的结果
 * IntStream:表示原始int流
 * TolntFunction接口中的方法   int applyAsInt(T value)]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        //需求：将集合中的字符串数据转换为整数之后在控制台输出
//        list.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
//        list.stream().map(Integer::parseInt).forEach(System.out::println);
//        list.stream().mapToInt(Integer::parseInt).forEach(System.out::println);

        //int sum() 返回此流中元素的总和
        int result = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(result);
    }
}
