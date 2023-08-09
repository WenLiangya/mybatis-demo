package com.beijing.leetcode.dayday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [*三数之和*:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/9 9:32]
 */
public class demo12 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution12 solution12 = new Solution12();
        List<List<Integer>> result = solution12.threeSum(nums);
        System.out.println(result);
    }
}

class Solution12 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 对数组进行排序
        Arrays.sort(nums);
        // 遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 将满足条件的三元组加入结果列表
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 和小于0，左指针向右移动
                } else {
                    right--; // 和大于0，右指针向左移动
                }
            }
        }
        return result;
    }
}

/*
该算法的时间复杂度为O(n^2)，其中n是数组的长度。排序的时间复杂度为O(nlogn)，
双指针的遍历时间复杂度为O(n)。空间复杂度为O(1)，只使用了常数级别的额外空间
*/

/*解题思路：
当给定一个整数数组nums时，我们需要找到所有满足以下条件的三元组：nums[i] + nums[j] + nums[k] = 0，其中i != j，i != k，j != k。我们需要返回所有满足条件且不重复的三元组。
为了解决这个问题，我们可以使用双指针的方法。首先，我们对数组进行排序，这样可以方便地使用双指针。
算法的步骤如下：
1. 对数组进行排序，以便使用双指针。
2. 遍历数组，将当前元素作为第一个数（nums[i]）。
3. 使用双指针left和right，将left指向当前元素的下一个位置，将right指向数组的末尾。
4. 在left < right的条件下，进行循环：
   - 计算当前三个数的和sum = nums[i] + nums[left] + nums[right]。
   - 如果sum等于0，则将这个三元组加入结果列表中，并移动left和right指针。
   - 如果sum小于0，则将left指针向右移动一位。
   - 如果sum大于0，则将right指针向左移动一位。
   - 在移动指针之前，需要跳过重复的元素，以避免得到重复的三元组。
5. 继续遍历数组，重复步骤2到步骤4，直到遍历完所有元素。
6. 返回结果列表。
*/