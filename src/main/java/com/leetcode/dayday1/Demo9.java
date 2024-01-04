package com.leetcode.dayday1;

import java.util.Arrays;

/**
 * [*删除每行中的最大值*:
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 * 执行下述操作，直到 grid 变为空矩阵：
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 * <p>
 * 返回执行上述操作后的答案。
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/27 20:07]
 */
public class Demo9 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.deleteGreatestValue(grid));
    }
}

class Solution9 {
    public int deleteGreatestValue(int[][] grid) {
        //把每一行用Arrays.sort排序
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int[] max = new int[grid[0].length];
        //把每一行的值放到max数组中
        for (int[] temp : grid) {
            //把每一列的最大值替换到max数组中
            for (int i = 0; i < temp.length; i++) {
                max[i] = Math.max(max[i], temp[i]);
            }
        }
        int sum = 0;
        //把max数组中的值相加得到结果
        for (int var : max) {
            sum += var;
        }
        return sum;
    }
}