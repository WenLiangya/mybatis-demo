package com.beijing.leetcode.dayday;

/**
 * [给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/1 13:17]
 */
class demo3 {
    public static void main(String[] args) {
        int[] array = {2, 9, 1, 5, 3, 6, 4};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxProfit(array));
    }
}

class Solution3 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxLR = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            if ((price - minPrice) > maxLR) {
                maxLR = price - minPrice;
            }
        }

        return maxLR;
    }
}