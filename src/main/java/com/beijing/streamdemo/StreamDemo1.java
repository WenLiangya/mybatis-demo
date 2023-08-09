package com.beijing.streamdemo;

import java.util.ArrayList;

/**
 * [需求：按照下面的要求完成集合的创建和遍历
 * 1:创建一个集合，存储多个字符串元素
 * 2:把集合中所有以”张"开头的元素存储到一个新的集合
 * 3:把"张"开头的集合中的长度为的元素存储到一个新的集合
 * 4:遍历上一步得到的集合]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王宝强");
        list.add("柳岩");
        list.add("张敏");
        list.add("张三丰");
        ArrayList<String> zhangList = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                zhangList.add(s);
            }
        }
        ArrayList<String> threeList = new ArrayList<>();
        for (String s : zhangList) {
            if (s.length() == 3) {
                threeList.add(s);
            }
        }
        System.out.println(threeList);

        System.out.println("--------------------------");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
