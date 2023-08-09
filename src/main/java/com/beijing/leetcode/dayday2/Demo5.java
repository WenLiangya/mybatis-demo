package com.beijing.leetcode.dayday2;

/**
 * [*整数的各位积和之差*:
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/9 20:07]
 */
public class Demo5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.subtractProductAndSum(2345));
    }
}

class Solution5 {
    public int subtractProductAndSum(int n) {
        int sum = 0;//和
        int product = 1;//积   product 乘积
        while (n > 0) {
            int temp = n % 10;//取余数
            sum += temp;
            product *= temp;
            n /= 10;//除以10,取整,去掉最后一位
        }
        return product - sum;
    }
}