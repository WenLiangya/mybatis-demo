package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/4 13:43]
 */
public class day4_2 {
    public static void main(String[] args) {
        //生成测试用例
        ListNode4_2 l1 = new ListNode4_2(2);
        ListNode4_2 l2 = new ListNode4_2(5);
        l1.next = new ListNode4_2(4);
        l1.next.next = new ListNode4_2(3);
        l2.next = new ListNode4_2(6);
        l2.next.next = new ListNode4_2(4);
        ListNode4_2 listNode42 = new Solution4_2().addTwoNumbers(l1, l2);
        while (listNode42 != null) {
            System.out.println(listNode42.val);
            listNode42 = listNode42.next;
        }
    }
}

/**
 * 2. 两数相加
 * 中等
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
class Solution4_2 {
    public ListNode4_2 addTwoNumbers(ListNode4_2 l1, ListNode4_2 l2) {
        // 创建一个新的链表，pre是其虚拟头节点
        ListNode4_2 pre = new ListNode4_2(0);
        // 创建一个指针cur，指向当前处理的节点
        ListNode4_2 cur = pre;
        // carry表示进位
        int carry = 0;
        // 当l1或l2不为空时，进入循环
        while (l1 != null || l2 != null) {
            // 如果l1不为空，取l1的值，否则取0
            int x = l1 == null ? 0 : l1.val;
            // 如果l2不为空，取l2的值，否则取0
            int y = l2 == null ? 0 : l2.val;
            // 计算当前位的和
            int sum = x + y + carry;

            // 更新进位
            carry = sum / 10;
            // 计算当前位的值
            sum = sum % 10;
            // 创建一个新的节点，值为sum，然后将cur的next指向这个新节点
            cur.next = new ListNode4_2(sum);

            // 将cur向后移动一位
            cur = cur.next;
            if (l1 != null) {
                // 如果l1不为空，将l1向后移动一位
                l1 = l1.next;
            }
            if (l2 != null) {
                // 如果l2不为空，将l2向后移动一位
                l2 = l2.next;
            }
        }

        // 如果最后还有进位
        if (carry == 1) {
            // 创建一个新的节点，值为carry，然后将cur的next指向这个新节点
            cur.next = new ListNode4_2(carry);
        }
        // 返回结果链表的头节点
        return pre.next;
    }
}
class ListNode4_2 {
    int val;
    ListNode4_2 next;

    ListNode4_2(int x) {
        val = x;
        next = null;
    }
}