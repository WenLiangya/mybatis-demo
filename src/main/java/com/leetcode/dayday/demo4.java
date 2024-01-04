package com.leetcode.dayday;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/2 15:59]
 */
public class demo4 {
    public static void main(String[] args) {
        int[] array = {1, 3, 1, 0, 2, 4, 3, 2, 1, 0};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.canJump(array));
    }
}

class Solution4 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}