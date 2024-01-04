package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/3 14:03]
 */
public class day3_2 {
}

/**
 * 21. 合并两个有序链表
 * 简单
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class Solution3_2 {
    public ListNode3_2 mergeTwoLists(ListNode3_2 list1, ListNode3_2 list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class ListNode3_2 {
    int val;
    ListNode3_2 next;

    ListNode3_2() {
    }

    ListNode3_2(int val) {
        this.val = val;
    }

    ListNode3_2(int val, ListNode3_2 next) {
        this.val = val;
        this.next = next;
    }
}