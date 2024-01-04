package com.leetcode.dayday;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 10:19]
 */
class demo1 {
}

class Solution {

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(array);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
