package com.beijing.leetcode.dayday1;

/**
 * [*剑指 Offer 58 - II. 左旋转字符串*
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/13 20:02]
 */
class Demo1 {
    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        Solution solution = new Solution();
        //方法一
        System.out.println(solution.reverseLeftWords(str, n));
        //方法二
        System.out.println(solution.reverseLeftWords1(str, n));
    }
}

class Solution {
    /**
     * 列表遍历拼接
     * 新建一个 list(Python)、StringBuilder(Java) ，记为 resresres ；
     * 先向 resresres 添加 “第 n+1n + 1n+1 位至末位的字符” ；
     * 再向 resresres 添加 “首位至第 nnn 位的字符” ；
     * 将 resresres 转化为字符串并返回。
     */
    public String reverseLeftWords(String s, int n) {
        if(s == null || s.length() == 0||n<=0||n>=s.length()){
            return s;
        }

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    /**
     * 字符串切片
     * 获取字符串 s[n:]s[n:]s[n:] 切片和 s[:n]s[:n]s[:n] 切片，使用 "+" 运算符拼接并返回即可
     */
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}