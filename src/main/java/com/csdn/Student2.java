package com.csdn;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/31 10:16]
 */
public class Student2 extends Student1 {
    public static void main(String[] args) {
        Student2 student2 = new Student2();
        student2.setName("张三");
        student2.setAge(28);
        student2.setAddress("上海");
        System.out.println(student2);
        student2.play1();
        student2.play2();
    }
}
