package com.leetcode.month10;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/10/25 14:02]
 */
public class Demo10_25 {
    public static void main(String[] args) {
        int n1 = 9;
        int result1 = f(n1);
        System.out.println(result1);

        int n2 = 9;
        int result2 = f(n2);
        System.out.println(result2);
    }

    /**
     * 求斐波那契数列第n项的值
     *
     * @param n 第n项
     * @return 第n项的值
     */
    static int f(int n) {
        if (n <= 2) {
            return 1;
        }
        // 递归调用
        return f(n - 1) + f(n - 2);
    }

    static int qw(int n) {
        if (n <= 2) {
            return n;
        }
        return qw(n - 1) + qw(n - 2);
    }
}