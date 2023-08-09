package com.beijing.leetcode.dayday;

/**
 * [给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 10:50]
 */
class demo2 {
    public static void main(String[] args) {
        int[] array = {1, 5, 11, 5};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.canPartition(array));
    }
}

class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 若和不能被2整除，肯定找不到
        if (sum % 2 != 0) {
            return false;
        }

        // 建立背包
        int[][] dp = new int[nums.length][sum / 2 + 1];

        // 初始化背包
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = nums[0]; j <= sum / 2; j++) {
            dp[0][j] = nums[0];
        }

        // 开始遍历计算
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[nums.length - 1][sum / 2] == sum / 2;
    }
}

