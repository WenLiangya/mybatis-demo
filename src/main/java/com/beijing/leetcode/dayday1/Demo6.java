package com.beijing.leetcode.dayday1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [*两个数组的交集*:
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/23 20:54]
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Solution6 solution6 = new Solution6();
        System.out.println(Arrays.toString(solution6.intersection(nums1, nums2)));
    }
}

class Solution6 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 创建一个HashSet用于存储交集元素
        Set<Integer> set = new HashSet<>();
        // 遍历第一个数组，将元素添加到HashSet中
        for (int num : nums1) {
            set.add(num);
        }
        // 创建一个动态数组，用于存储结果
        int[] result = new int[set.size()];
        int index = 0;
        // 遍历第二个数组，如果元素存在于HashSet中，则添加到结果数组中
        for (int num : nums2) {
            if (set.contains(num)) {
                result[index++] = num;
                // 删除已重合的数，避免结果有重复数字
                set.remove(num);
            }
        }
        // 调整结果数组的大小，去除多余的空间
        return Arrays.copyOf(result, index);
    }
}