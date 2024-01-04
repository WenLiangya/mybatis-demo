package com.leetcode.month12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/12/29 15:19]
 */
public class day29_2 {
    public static void main(String[] args) {
        //生产测试用例
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println((new Solution29_2().groupAnagrams(strs)));
    }
}

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
class Solution29_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)//将数组转化为stream
                        .collect(Collectors.groupingBy(str -> {//使用groupingBy方法将数组转化为map
                            int[] counter = new int[26];//创建一个长度为26的数组，用于记录每个字母出现的次数
                            // 遍历字符串，统计每个字母出现的次数
                            for (int i = 0; i < str.length(); i++) {
                                counter[str.charAt(i) - 'a']++;
                            }
                            StringBuilder sb = new StringBuilder();
                            // 遍历数组，将出现次数大于0的字母添加到 sb 中
                            for (int i = 0; i < 26; i++) {
                                // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                                if (counter[i] != 0) {
                                    // 添加字母这，里的 i + 'a' 是为了将字符转换为对应的 ASCII 码，然后再转换为字符
                                    sb.append((char) ('a' + i));
                                    // 添加出现次数
                                    sb.append(counter[i]);
                                }
                            }
                            return sb.toString();
                        })).values());//.values()返回map中的所有value，这里返回的是一个list
    }
}