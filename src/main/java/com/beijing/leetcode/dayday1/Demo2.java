package com.beijing.leetcode.dayday1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [*四数之和*:
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b],
 * nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/15 20:57]
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        Solution2 solution2 = new Solution2();
        List<List<Integer>> result = solution2.fourSum(nums, target);
        System.out.println(result);
    }
}

class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            long num_i = nums[i];
            long num_i1 = nums[i + 1];
            long num_i2 = nums[i + 2];
            long num_i3 = nums[i + 3];
            long min = num_i + num_i1 + num_i2 + num_i3;
            if (min > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            long num_n1 = nums[n - 1];
            long num_n2 = nums[n - 2];
            long num_n3 = nums[n - 3];
            long max = num_i + num_n1 + num_n2 + num_n3;
            if (max < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long num_j = nums[j];
                long num_j1 = nums[j+1];
                long num_j2 = nums[j+2];
                long minFlag = num_i + num_j+num_j1+num_j2;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                if(minFlag>target){
                    break;
                }

                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                long maxFlag = num_i+num_j+num_n2+num_n1;
                if(maxFlag<target){
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long num_left = nums[left];
                    long num_right = nums[right];
                    long sum = num_i + num_j + num_left + num_right;

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}