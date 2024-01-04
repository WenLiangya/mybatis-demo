package com.leetcode.month12;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/28 14:21]
 */
public class day28_2 {
    public static void main(String[] args) {
        //生成测试用例
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution28_2().maxArea(height));
    }
}

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
class Solution28_2 {
    public int maxArea(int[] height) {
        int length = height.length;
        //边界条件，只有一个元素时，无法构成容器
        if (length < 2) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = getMaxArea(height, left, right);
        while (left < right) {
            if (leftMax <= rightMax) {
                while (left < right && height[left] <= leftMax) {
                    left++;
                }
                if (left < right) {
                    result = Math.max(result, getMaxArea(height, left, right));
                    leftMax = height[left];
                }
            } else {
                while (left < right && height[right] <= rightMax) {
                    right--;
                }
                if (left < right) {
                    result = Math.max(result, getMaxArea(height, left, right));
                    rightMax = height[right];
                }
            }
        }
        return result;
    }

    int getMaxArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}