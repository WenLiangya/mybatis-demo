package com.year2024.leetcode.month1;

import java.util.Arrays;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/2 11:17]
 */
public class day2_1 {
    public static void main(String[] args) {
        //生成测试用例
        int[] nums = {1,2,0,1};
        System.out.println(new Solution2_1().longestConsecutive(nums));
    }
}

/**
 * 128. 最长连续序列
 * 中等
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
class Solution2_1 {
    public int longestConsecutive(int[] nums) {
        //剪枝
        if (nums.length < 2) {
            return nums.length;
        }
        //排序
        Arrays.sort(nums);
        int temp = 1;
        int result = 1;
        //遍历，判断相邻元素是否连续，如果连续，则temp加1，否则，result更新为temp，temp重置为1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - 1 == nums[i - 1]) {
                temp++;
            } else {
                temp = 1;
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
