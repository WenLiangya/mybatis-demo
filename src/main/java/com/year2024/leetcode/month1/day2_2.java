package com.year2024.leetcode.month1;

import java.util.HashSet;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/2 11:33]
 */
public class day2_2 {
}


/**
 * 160. 相交链表
 * 简单
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution2_2 {
    public ListNode2_2 getIntersectionNode(ListNode2_2 headA, ListNode2_2 headB) {
        // 边界判断，如果其中一个为空，则直接返回null
        if (headA == null || headB == null) {
            return null;
        }
        // 将链表A转换成一个集合，方便后续判断
        HashSet<ListNode2_2> listNode = new HashSet<>();
        ListNode2_2 temp = headA;
        //遍历链表A
        while (temp != null) {
            // 如果链表A的节点不为null，则将链表A的节点添加到集合中
            listNode.add(temp);
            temp = temp.next;
        }
        temp = headB;
        //遍历链表B
        while (temp != null) {
            // 判断链表B的节点是否在链表A的集合中，如果存在，则说明链表B与链表A相交，返回该节点
            if (listNode.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

class ListNode2_2 {
    int val;
    ListNode2_2 next;

    ListNode2_2(int x) {
        val = x;
        next = null;
    }
}