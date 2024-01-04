package com.leetcode.month12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/28 16:34]
 */
public class day28_3 {
    public static void main(String[] args) {
        //生成测试数据
        int[] nums = {-1, 0, 1};
        System.out.println(new Solution28_3().threeSum(nums));
    }
}

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
class Solution28_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        //排序
        Arrays.sort(nums);
        if (n < 3) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            //去重，i-1是为了筛掉重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //剪枝
            if (n - i > 2) {
                if (nums[i] + nums[i + 1] + nums[i + 2] > 0 || nums[n - 1] + nums[n - 2] + nums[n - 3] < 0) {
                    break;
                }
                if (nums[i] + nums[n - 1] + nums[n - 2] < 0) {
                    continue;
                }
            }
            int left = 0;
            int right = n - 1;
            left = i + 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    //添加结果，asList是将数组转化为集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //两个while循环，去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //left右移，保证不会出现死循环
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return result;
    }
}