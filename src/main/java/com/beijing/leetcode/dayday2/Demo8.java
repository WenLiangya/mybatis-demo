package com.beijing.leetcode.dayday2;

/**
 * [*合并两个有序数组*:
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/13 20:32]
 */
public class Demo8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        solution8.merge(nums1,3,nums2,3);
        for (int j : nums1) {
            System.out.println(j);
        }
    }
}

class Solution8 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;// p1指向nums1数组的最后一个元素
        int p2 = n - 1;// p2指向nums2数组的最后一个元素
        int P = m + n - 1;// P指向nums1数组的最后一个位置
        while(p1 >= 0 && p2 >= 0) {// 当p1和p2都大于等于0时，进行循环
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            // 如果nums1[p1] > nums2[p2]，则将nums1[p1]赋值给nums1[P]，然后p1减1，
            // 否则将nums2[p2]赋值给nums1[P]，然后p2减1
            nums1[P--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        // 表示将nums2数组从下标0的位置开始，拷贝到nums1数组中，从下标0的位置开始，长度为p2+1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
