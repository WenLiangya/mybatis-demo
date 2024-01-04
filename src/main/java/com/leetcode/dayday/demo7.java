package com.leetcode.dayday;

import java.util.Arrays;

/**
 * [*除自身以外数组的乘积*
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。]
 * @author : [Jiu Meng]
 * @createTime : [2023/7/4 14:29]
 */
class demo7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(aaa(array)));
    }

    private static int[] aaa(int[] nums) {
        //第三种方法，空间复杂度为1，直接用output当做left和
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int j = len - 1; j >= 0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }
}
