package com.beijing.leetcode.dayday1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * [*将数组和减半的最少操作次数*:
 * 给你一个正整数数组 nums 。每一次操作中，你可以从nums中选择任意一个数并将它
 * 减小到 恰好 一半。（注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/25 21:14]
 */
public class Demo8 {
    public static void main(String[] args) {
        int[] arrays = {5, 19, 8, 1};
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.halveArray(arrays));
    }
}

class Solution8 {
    public int halveArray(int[] nums) {
        Arrays.sort(nums);
        double sum = 0;
        //new一个优先队列，重写比较器，实现大顶堆
        PriorityQueue<Double> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2, o1));
        //将数组中的元素全部放入优先队列中
        for (int num : nums) {
            sum += num;
            queue.add((double) num);
        }
        double half = sum / 2;
        int count = 0;
        while (sum > half) {
            //取出最大的元素
            double max = queue.poll();
            //将最大的元素减半
            max /= 2;
            //将减半后的元素重新放入优先队列中
            queue.add(max);
            //将数组和减半
            sum -= max;
            count++;
        }
        return count;
    }
}
