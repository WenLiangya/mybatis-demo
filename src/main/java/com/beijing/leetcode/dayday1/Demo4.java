package com.beijing.leetcode.dayday1;

/**
 * [*盛最多水的容器*:
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。* ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/20 19:36]
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};//49
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.maxArea(nums));
    }
}

class Solution4 {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, (right - left) * (Math.min(height[left], height[right])));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}