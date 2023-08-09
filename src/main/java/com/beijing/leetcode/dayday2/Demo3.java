package com.beijing.leetcode.dayday2;

/**
 * [*任意子数组和的绝对值的最大值*:
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * abs(x) 定义如下：
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/8 20:48]
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] nums = {2,-1};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxAbsoluteSum(nums));

        Solution3_1 solution3_1 = new Solution3_1();
        System.out.println(solution3_1.maxAbsoluteSum(nums));
    }
}

class Solution3 {
    public int maxAbsoluteSum(int[] nums) {
        //解题思路：
        //1. 从左到右遍历数组，计算当前的前缀和，如果前缀和小于 0，就将前缀和置为 0。
        //2. 从头到尾遍历数组，计算当前的前缀和，如果前缀和大于 max，则将 max 更新为当前前缀和。
        //3. 从头到尾遍历数组，计算当前的前缀和，如果前缀和小于 min，则将 min 更新为当前前缀和的值的相反数。
        //4. max 和 min 的差值即为答案。

        //为什么max 和 min 的差值即为答案?
        // 因为最大值是正数,最小值是负数,所以最大值减去最小值就是最大绝对值,所以只需要找到最大值和最小值即可,不需要找到最大值和最小值的位置

        //这个方法是什么解法?
        // 这个方法是动态规划,这个方法的时间复杂度是O(n),空间复杂度是O(1)

        //遍历
        int max = 0;//最大值
        int min = 0;//最小值
        int sum = 0;//前缀和
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return max - min;
    }
}

class Solution3_1 {
    public int maxAbsoluteSum(int[] nums) {
        // 数组长度为 1,直接返回
        if (nums.length == 1) {
            return Math.abs(nums[0]);
        }

        // 1. 暴力法
        int sum = 0;// 保存最大值
        // 遍历数组，计算每个子数组的和，取最大值
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];// 保存每个子数组的和
            sum = Math.max(sum, Math.abs(temp));
            for (int j = i + 1; j < nums.length; j++) {// 遍历子数组
                temp += nums[j];
                // 取最大值
                sum = Math.max(sum, Math.abs(temp));
            }
        }
        return sum;
    }
}