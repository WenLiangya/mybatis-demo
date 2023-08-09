package com.beijing.streamdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/**
 * [Stream流的常见生成方式
 * 1:Collection体系的集合可以使用默认方法stream()生成流
 *      default Stream<E>stream (
 * 2:Map体系的集合间接的生成流
 * 3:数组可以通过Stream接口的静态方法of(T.·values)生成流]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/3 17:30]
 */
class StreamDemo2 {
    public static void main(String[] args) {
        //1:Collection体系的集合可以使用默认方法stream()生成流
        ArrayList<String> list = new ArrayList<>();
        Stream<String> listStream = list.stream();

        HashSet<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        //2:Map体系的集合间接的生成流
        HashMap<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        //3:数组可以通过Stream接口的静态方法of(T.·values)生成流
        String[] strArray = {"a", "b", "c", "d", "e"};
        Stream<String> strArrayStream = Stream.of(strArray);
        Stream.of("hello", "world","!","hello","java","!");
    }
}
