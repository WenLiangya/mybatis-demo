package com.leetcode.dayday;

import java.util.Arrays;

/**
 * [两数之和plus:
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足
 * 相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/8 10:48]
 */
class demo10 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4};
        int target = 6;
        Solution10 solution10 = new Solution10();
        System.out.println(Arrays.toString(solution10.twoSum(array, target)));
    }

}

class Solution10 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        // 左指针，指向数组的起始位置
        int right = numbers.length - 1;
        // 右指针，指向数组的末尾位置
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // 计算当前左右指针指向的两个数的和
            if (sum == target) {
                return new int[]{left + 1, right + 1};
                // 如果和等于目标数，则返回两个数的下标（下标从1开始）
            } else if (sum < target) {
                left++;
                // 如果和小于目标数，则将左指针向右移动，增大和的值
            } else{
                right--;
                // 如果和大于目标数，则将右指针向左移动，减小和的值
            }
        }
        return new int[]{-1, -1};
        // 如果没有找到满足条件的两个数，则返回[-1, -1]

    }
}