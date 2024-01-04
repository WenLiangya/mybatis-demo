package com.leetcode.month12;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/29 11:27]
 */
public class day29 {
    public static void main(String[] args) {
        //生产测试用例
        System.out.println(new Solution29().trap(new int[]{2,0,2}));
    }
}

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
class Solution29 {
    public int trap(int[] height) {
        int index = maxNumIndex(height);
        int n = height.length;
        int result = 0;
        int left = 0, right = n - 1;
        //剪枝
        if (n < 3) {
            return 0;
        }
        //左边，将最高点作为边界，计算最高点左边的雨水
        for (int i = 1; i < index; i++) {
            //当前位置柱子是否高于左边最高柱子，如果是，则替换为左最高柱子，如果不是，则计算当前柱子与左边最高柱子的差值，累加到结果中
            if (height[i] >= height[left]) {
                left = i;
            } else {
                result += (height[left] - height[i]);
            }
        }
        //右边
        for (int i = n - 2; i > index; i--) {
            //当前位置柱子是否高于右边最高柱子
            if (height[i] >= height[right]) {
                right = i;
            } else {
                result += (height[right] - height[i]);
            }
        }
        return result;
    }

    int maxNumIndex(int[] height) {
        int maxNumber = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxNumber) {
                maxNumber = height[i];
                index = i;
            }
        }
        return index;
    }
}
