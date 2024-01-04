package com.leetcode.month12;

/**
 * [最大子数组和：给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/12 16:53]
 */
public class day12 {
    //生成测试用例
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        //记录最大子数组和
        int temp = 0;
        //记录当前子数组的和
        for (int num : nums) {
            //遍历数组
            if (temp > 0) {
                //如果当前子数组的和大于0,则加上当前数值
                temp += num;
            } else {
                //如果当前子数组的和小于等于0,则直接赋值给当前子数组的和
                temp = num;
            }

            //更新最大子数组和
            result = Math.max(result, temp);
        }
        return result;
    }
}