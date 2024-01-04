package com.csdn;

import lombok.Data;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/31 10:11]
 */
@Data
public class Student1 {
    public String name;
    protected int age;
    private String address;

    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.name = "小明";
        student1.age = 18;
        student1.address = "北京";

        System.out.println("------------play1()-------------");
        student1.play1();
        System.out.println("------------play2()-------------");
        student1.play2();
        System.out.println("------------play3()-------------");
        student1.play3();
    }

    public void play1() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.address);
    }

    protected void play2() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.address);
    }

    private void play3() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.address);
    }
}
