package com.csdn;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/31 11:01]
 */
public class equalsTest {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.setName("zhangsan");
        Student2 s2 = new Student2();
        s2.setName("zhangsan");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }
}
