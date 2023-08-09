package com.beijing.leetcode.dayday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [两数之和:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/7 20:10]
 */
class demo9 {
    public static void main(String[] args) {
        int[] array = {2, 6, 11, 15, 3};
        Solution9 solution9 = new Solution9();
        System.out.println(Arrays.toString(solution9.twoSum(array, 9)));
    }
}

class Solution9 {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个HashMap来存储元素和它们的索引
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int flag = target - nums[i];
            // 检查差值是否存在于HashMap中
            if (hashMap.containsKey(flag)) {
                // 返回两个元素的索引
                return new int[]{hashMap.get(flag), i};
            }
            // 将当前元素和它的索引存入HashMap中
            hashMap.put(nums[i], i);
        }
        // 如果没有找到解，则返回一个空数组
        return new int[0];
    }
}