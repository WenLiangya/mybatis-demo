package com.leetcode.dayday1;

import java.util.HashSet;

/**
 * [* 宝石与石头*:
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * 例如：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/24 19:41]
 */
public class Demo7 {
    public static void main(String[] args) {
        String str1 = "aA";
        String str2 = "aAAbbbb";
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.numJewelsInStones(str1, str2));
    }
}

class Solution7 {
    public int numJewelsInStones(String jewels, String stones) {
        char[] arr1 = jewels.toCharArray();
        char[] arr2 = stones.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : arr1) {
            set.add(c);
        }

        int result = 0;
        for (char c : arr2) {
            if (set.contains(c)) {
                result++;
            }
        }

        return result;
    }
}