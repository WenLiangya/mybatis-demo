package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/3 13:42]
 */
public class day3_1 {
    public static void main(String[] args) {
        //生产测试用例
        ListNode3_1 head = new ListNode3_1(1);
        head.next = new ListNode3_1(2);
        head.next.next = head;
        System.out.println(new Solution3_1().hasCycle(head));
    }
}

/**
 * 141. 环形链表
 * 简单
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
class Solution3_1 {
    public boolean hasCycle(ListNode3_1 head) {
        //边界条件，链表为空或者只有一个节点，则不存在环
        if (head == null || head.next == null) {
            return false;
        }
        //设置快慢指针，快指针每次移动两步，慢指针每次移动一步，如果存在环，则快慢指针一定会相遇
        ListNode3_1 slow = head.next;
        ListNode3_1 fast = head.next.next;
        //fast指针移动到链表尾部，则不存在环，fast.next!=null防止fast指针越界
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

class ListNode3_1 {
    int val;
    ListNode3_1 next;

    ListNode3_1(int x) {
        val = x;
        next = null;
    }
}