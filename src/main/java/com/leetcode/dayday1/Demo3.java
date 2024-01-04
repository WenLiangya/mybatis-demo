package com.leetcode.dayday1;

/**
 * [* 字符串相加*:
 *给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），
 * 也不能直接将输入的字符串转换为整数形式。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/17 20:02]
 */
public class Demo3 {
    public static void main(String[] args) {
        String num1 = "88";
        String num2 = "133";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.addStrings(num1, num2));
    }
}
class Solution3 {
    public String addStrings(String num1, String num2) {
        // 用于构建结果字符串的 StringBuilder 对象
        StringBuilder result = new StringBuilder();
        // num1 字符串的末尾索引
        int i = num1.length() - 1;
        // num2 字符串的末尾索引
        int j = num2.length() - 1;
        // 进位标志
        int carry = 0;
        // 逆序遍历两个输入字符串，并进行相加
        while (i >= 0 || j >= 0 || carry > 0) {
            // 获取当前位的数字，如果索引越界则默认为 0
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // 当前位的和（包括进位）
            int sum = digit1 + digit2 + carry;
            // 更新进位标志
            carry = sum / 10;
            // 当前位的数字
            int digit = sum % 10;
            // 将当前位的数字插入到结果字符串的最前面
            result.insert(0, digit);
            // 更新索引
            i--;
            j--;
        }
        // 将结果转换为字符串并返回
        return result.toString();
    }
}