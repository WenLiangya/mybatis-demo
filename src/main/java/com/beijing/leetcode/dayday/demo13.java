package com.beijing.leetcode.dayday;

import java.util.Arrays;

/**
 * [*最接近的三数之和*:
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/10 20:22]
 */
public class demo13 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.threeSumClosest(nums,target));
    }
}

class Solution13 {
    public int threeSumClosest(int[] nums, int target) {
        // 首先对数组进行排序
        Arrays.sort(nums);
        // 初始化最接近的和为前三个数的和
        int minSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 左指针从当前元素的下一个位置开始
            int left = i + 1;
            // 右指针从最后一个元素开始
            int right = nums.length - 1;
            while (left < right) {
                // 当前三个数的和
                int sum = nums[i] + nums[left] + nums[right];
                // 如果当前和与目标值的差距更小，则更新最接近的和
                if (Math.abs(sum - target) < Math.abs(minSum - target)) {
                    minSum = sum;
                }
                // 根据当前和与目标值的大小关系，移动指针
                if (sum < target) {
                    // 和偏小，左指针右移
                    left++;
                } else if (sum > target) {
                    // 和偏大，右指针左移
                    right--;
                } else {
                    // 如果和等于目标值，则直接返回和
                    return sum;
                }
            }
        }
        // 返回最接近的和
        return minSum;
    }
}

/*
解题思路：这个解法使用了双指针的思路。首先对数组进行排序，然后遍历数组中的每一个元素。
在每次遍历中，使用两个指针分别指向当前元素的下一个位置和数组的最后一个位置。
计算当前三个数的和，并将其与目标值进行比较。根据比较结果，移动指针以逼近最接近的和。
最后返回最接近的和作为结果。
[请注意，这个解法假设每组输入只存在恰好一个解!!]
*/

/*
这里使用 i < nums.length - 2 的条件是因为在遍历过程中，我们需要至少保留三个元素来构成三个数的组合。
如果 i 的值达到 nums.length - 2 ，那么 i 所指向的元素是倒数第三个元素，
此时已经没有足够的元素来构成三个数的组合了。
举个例子，假设数组 nums 的长度为5。如果我们使用 i < nums.length 作为条件，
那么 i 的值会取0、1、2、3、4，而在 i 等于3或4时，我们无法再取到两个后续的元素来构成三个数的组合。
因此，我们需要使用 i < nums.length - 2 的条件，确保在遍历过程中至少有三个元素可用。
总结起来， i < nums.length - 2 的条件确保了我们在遍历过程中至少有三个元素可用来构成三个数的组合。
*/