package com.beijing.leetcode.dayday1;

import java.util.HashSet;

/**
 * [*环形链表 II*:
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/31 21:17]
 */
public class Demo11 {
    public static void main(String[] args) {
        //3,2,0,-4
        // 1.创建链表
        ListNode12 head = new ListNode12(3);
        ListNode12 node2 = new ListNode12(2);
        ListNode12 node3 = new ListNode12(0);
        ListNode12 node4 = new ListNode12(-4);
        // 2.创建节点,并且把节点加入到链表中
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head;

        // 3.调用方法
        Solution11 solution11 = new Solution11();
        ListNode12 result = solution11.detectCycle(head);
        System.out.println(result.val);
    }
}

class Solution11 {
    public ListNode12 detectCycle(ListNode12 head) {
        // 思路：
        // 1.建立set集合
        // 2.如果set集合中没有当前节点，就把当前节点加入到set集合中
        // 3.如果set集合中有当前节点，说明有环，返回当前节点且当前节点就是入环的第一个节点

        // 1.建立set集合
        HashSet<ListNode12> set = new HashSet<>();
        while (head != null) {
            // 如果有环，就返回当前节点,且当前节点就是入环的第一个节点,因为set集合中已经有当前节点了
            if (set.contains(head)) {
                return head;
            }
            // 如果没有环，就把节点加入到set集合中
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

// /**
//  * 单链表的定义
//  */
// class ListNode {
//     int val;
//     ListNode next;
//
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }