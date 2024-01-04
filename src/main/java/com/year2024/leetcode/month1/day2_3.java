package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/2 15:24]
 */
public class day2_3 {
    public static void main(String[] args) {
        //生成测试用例
        ListNode2_3 head = new ListNode2_3(1);
        head.next = new ListNode2_3(2);
        head.next.next = new ListNode2_3(3);
        head.next.next.next = new ListNode2_3(4);
        head.next.next.next.next = new ListNode2_3(5);
        Solution2_3 solution2_3 = new Solution2_3();
        ListNode2_3 listNode = solution2_3.reverseList(head);
        //打印链表
        while (listNode!= null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

/**
 * 206. 反转链表
 * 简单
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
class Solution2_3 {
    public ListNode2_3 reverseList(ListNode2_3 head) {
        ListNode2_3 pre = null;
        ListNode2_3 cur = head;
        //反转链表，每次循环都将当前节点的next指向前一个节点，并将当前节点指向前一个节点
        while (cur != null) {
            ListNode2_3 temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

class ListNode2_3 {
    int val;
    ListNode2_3 next;

    ListNode2_3() {
    }

    ListNode2_3(int val) {
        this.val = val;
    }

    ListNode2_3(int val, ListNode2_3 next) {
        this.val = val;
        this.next = next;
    }
}