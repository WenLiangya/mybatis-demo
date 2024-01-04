package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/2 17:34]
 */
public class day2_4 {
    public static void main(String[] args) {
        //生成测试用例
        ListNode2_4 head = new ListNode2_4(1);
        head.next = new ListNode2_4(1);
        head.next.next = new ListNode2_4(2);
        head.next.next.next = new ListNode2_4(1);
        System.out.println(new Solution2_4().isPalindrome(head));
    }
}

/**
 * 234. 回文链表
 * 简单
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
class Solution2_4 {
    public boolean isPalindrome(ListNode2_4 head) {
        if(head == null || head.next == null) {
            return true;
        }
        // 快慢指针，快指针每次走两步，慢指针每次走一步
        ListNode2_4 slow = head, fast = head;
        // 记录前一个节点，用于断开链表
        ListNode2_4 pre = head, prepre = null;
        // 快慢指针，当快指针到达链表的末尾时，慢指针指向链表的中间节点
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        // 快指针走到链表的末尾时，慢指针指向链表的中间节点的下一个节点
        if(fast != null) {
            slow = slow.next;
        }
        // 遍历链表，判断是否是回文链表
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}


class ListNode2_4 {
    int val;
    ListNode2_4 next;

    ListNode2_4() {
    }

    ListNode2_4(int val) {
        this.val = val;
    }

    ListNode2_4(int val, ListNode2_4 next) {
        this.val = val;
        this.next = next;
    }
}