package com.beijing.leetcode.dayday2;

/**
 * [*最长公共前缀*:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/14 21:27]
 */
public class Demo10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution10.longestCommonPrefix(strs));
    }
}
class Solution10{
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){//判断数组是否为空
            return "";
        }
        String prefix = strs[0];//取第一个字符串为前缀
        for(int i=1;i<strs.length;i++){//遍历数组
            //indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。
            while(strs[i].indexOf(prefix)!=0){//判断是否是前缀,不是则去掉最后一个字符,再判断,直到是前缀,或者前缀为空
                prefix = prefix.substring(0,prefix.length()-1);//去掉最后一个字符
                if(prefix.isEmpty()) {//如果前缀为空,则返回空
                    return "";
                }
            }
        }
        return prefix;
    }
}
