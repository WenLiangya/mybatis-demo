package com.leetcode.dayday;

/**
 * [*交替数字和*:
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/12 19:35]
 */
public class demo14 {
    public static void main(String[] args) {
        int n = 8869967;
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.alternateDigitSum(n));
    }
}

class Solution14 {
    public int alternateDigitSum(int n) {
        int result = 0;
        while(n > 0) {
            result = n % 10 - result;
            n /= 10;
        }

        return result;
    }
}


/*
从低位到高位遍历正整数的各位数字时，用当前位的数字减去前面低位的数字交替和。
等遍历到最高位的时候，最高有效位上的数字分配到的符号正好是正号，
所以就不需要另外用符号变量sign来保证各位数字分配到相应的正号或负号


*/