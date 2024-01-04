package com.leetcode.dayday2;

import java.util.Stack;

/**
 * [给定一个字符串sum(1,2),实现求和功能。
 * 例子：
 * 输入sum(1,2),输出3
 * 输入sum(1,sum(2,3)),输出6
 * 输入sum(sum(1,2),sum(3,4)),输出10
 * sum可以不断的嵌套，不能只处理数字，需要解析整个字符串
 *]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/8 21:16]
 */
public class Demo4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.calculateSum("sum(1,2)"));//3
        System.out.println(solution4.calculateSum("sum(1,sum(2,3))"));//6
        System.out.println(solution4.calculateSum("sum(sum(1,2),sum(3,4))"));//10
        System.out.println(solution4.calculateSum("sum(sum(-2,1),sum(-8,4))"));//-5
    }
}

class Solution4 {
    //给定一个字符串sum(1,2),实现求和功能。
    // 例子：
    // 输入sum(1,2),输出3
    // 输入sum(1,sum(2,3)),输出6
    // 输入sum(sum(1,2),sum(3,4)),输出10
    // sum可以不断的嵌套，不能只处理数字，需要解析整个字符串,请给出解题代码

    public int calculateSum(String s) {
        //new一个栈，用来保存括号前的结果和符号
        Stack<Integer> stack = new Stack<>();
        int num = 0;// 保存当前的数字
        int sign = 1;// 保存当前的符号，1为正，-1为负
        int result = 0;// 保存最终的结果
        for (char c : s.toCharArray()) {// 遍历字符串
            if (Character.isDigit(c)) {// 如果当前字符是数字
                num = num * 10 + (c - '0');// 计算数字
            } else if (c == '(') {// 如果当前字符是左括号
                stack.push(result);// 将当前结果保存到栈中
                stack.push(sign);// 将当前符号保存到栈中
                result = 0;// 将当前结果清0
                sign = 1;// 将当前符号置为1，即正号
            } else if (c == ')') {// 如果当前字符是右括号，说明一个括号内的表达式结束了
                result += sign * num;// 计算结果
                num = 0;// 将当前数字清0
                result *= stack.pop(); // 弹出括号前的符号
                result += stack.pop(); // 弹出括号前的结果
            } else if (c == ',') {// 如果当前字符是逗号，说明一个数字结束了
                result += sign * num;// 计算结果
                num = 0;// 将当前数字清0
                sign = 1;// 将当前符号置为1，即正号
            } else if (c == '-') {// 如果当前字符是减号
                sign = -1;// 将当前符号置为-1，即负号
            }
        }
        return result + (sign * num);// 返回结果,最后一个数字后面没有逗号，所以要单独计算,这里的sign*num是为了处理最后一个数字是负数的情况
    }
}
