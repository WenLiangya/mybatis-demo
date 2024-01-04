package com.leetcode.month10;

import java.util.Arrays;

/**
 * [*字符串中的查找与替换*:
 * https://leetcode.cn/problems/find-and-replace-in-string/]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/15 20:54]
 */
public class Demo1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(solution.findReplaceString(s, indices, sources, targets));
    }
}

class Solution1 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        String[] Str = new String[n]; // 替换后的字符串
        int[] len = new int[n];    // 被替换的长度
        Arrays.fill(len, 1);     // 无需替换时,长度为1
        for (int i = 0; i < indices.length; i++) {// 需要替换时,长度为源字符串的长度,并且替换后的字符串为目标字符串
            int idx = indices[i];// 起始位置
            if (s.startsWith(sources[i], idx)) {// 判断是否需要替换,startsWith()方法的第二个参数是起始位置,返回值为boolean
                Str[idx] = targets[i];// 替换后的字符串,用于后续的拼接,无需替换时,为null
                len[idx] = sources[i].length();// 被替换的长度,用于后续的跳跃,无需替换时,长度为1
            }
        }

        // 拼接字符串,跳跃,无需替换时,跳跃长度为1
        StringBuilder result = new StringBuilder();// 拼接后的字符串
        for (int i = 0; i < n; i += len[i]) { // 无需替换时,长度为1
            if (Str[i] == null) {// 无需替换时,直接拼接
                result.append(s.charAt(i));//s.charAt(i)返回指定索引处的 char 值
            } else {// 需要替换时,拼接替换后的字符串
                result.append(Str[i]);
            }
        }
        return result.toString();
    }
}