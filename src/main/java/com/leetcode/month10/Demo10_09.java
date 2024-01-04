package com.leetcode.month10;

import java.util.Arrays;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/10/9 14:24]
 */
public class Demo10_09 {
    public static void main(String[] args) {
        //测试代码
        Solution10_09 solution10_09 = new Solution10_09();
        int num = 4325;
        int splitNum = solution10_09.splitNum(num);
        System.out.println(splitNum);
    }
}

class Solution10_09 {
    public int splitNum(int num) {
        //为什么要加""，因为要转换成字符串，不然会报错，因为toCharArray()是字符串的方法
        //转换成字符数组,方便排序
        char[] s = (num + "").toCharArray();
        //排序
        Arrays.sort(s);
        int[] ans = new int[2];
        for (int i = 0; i < s.length; ++i) {
            //判断奇偶,奇数位放在ans[0],偶数位放在ans[1],这样就可以保证两个数的位数相同
            ans[i % 2] = ans[i % 2] * 10 + s[i] - '0';
            //- '0'是为了将字符转换成数字
        }
        return ans[0] + ans[1];
    }
}