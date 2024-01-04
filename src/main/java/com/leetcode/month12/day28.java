package com.leetcode.month12;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/28 11:29]
 */
public class day28 {
    public static void main(String[] args) {
        //编写测试用例
        new Solution28().moveZeroes(new int[]{1, 0});
    }
}

class Solution28 {

    public void moveZeroes(int[] nums) {
        // 收集非零的数,将非零元素移动到数组的前面
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 最后将剩余的位置填充为0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}