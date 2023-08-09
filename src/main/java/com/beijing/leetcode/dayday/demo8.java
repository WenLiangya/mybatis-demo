package com.beijing.leetcode.dayday;

/**
 * [幸运数字:
 * 定义一个幸运数字的标准包含3条:
 * 1、仅包含4和7。
 * 2、数字的前半部分等于后半年部分。
 * 3、数字的长度是偶数。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/4 14:48]
 */
class demo8 {
}

class LuckyNumber {
    public static boolean isLuckyNumber(int num) {
        String strNum = String.valueOf(num);
        int length = strNum.length();
        // 条件1：仅包含4和7
        for (int i = 0; i < length; i++) {
            char flag = strNum.charAt(i);
            if (flag != '4' && flag != '7') {
                return false;
            }
        }
        // 条件2：前半部分等于后半部分
        int targer = length / 2;
        int left = 0;
        int right = 0;
        for (int i = 0; i < targer; i++) {
            left += Character.getNumericValue(strNum.charAt(i));
            right += Character.getNumericValue(strNum.charAt(i + targer));
            for (int j = -1; j < i; j++) {
                if (i == 1) {
                    break;
                }
                left *= 10;
                right *= 10;
            }
        }
        if (left != right) {
            return false;
        }

        // 条件3：长度为偶数
        return length % 2 == 0;
    }

    public static void main(String[] args) {
        int num = 4774;
        System.out.println(isLuckyNumber(num));
    }
}