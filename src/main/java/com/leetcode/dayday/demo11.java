package com.leetcode.dayday;

/**
 * [两数相加:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/8 20:09]
 */
public class demo11 {
    public static void main(String[] args) {
        // 创建链表 l1: 2 -> 4 -> 3
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);
        // 创建链表 l2: 5 -> 6 -> 4
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        Solution11 solution11 = new Solution11();
        // 调用 addTwoNumbers 方法计算链表的和
        ListNode result = solution11.addTwoNumbers(l1, l2);
        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }
}

class Solution11 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        // 创建一个虚拟的头节点，方便操作链表
        ListNode current = dummy;
        // 创建一个指针current，指向当前节点，初始时指向虚拟头节点
        int carry = 0;
        // 进位值，初始为0
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // 获取当前节点的值，如果节点为空则取0
            int sum = carry + x + y;
            // 计算当前节点的和，包括进位值和两个节点的值
            carry = sum / 10;
            // 更新进位值，取整除法运算结果
            current.next = new ListNode(sum % 10);
            // 创建一个新节点，存储当前节点的个位数
            current = current.next;
            // 将指针current移动到下一个节点
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            // 将两个链表的指针都向后移动一位
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
            // 如果最后还有进位值，创建一个新节点存储进位值
        }
        return dummy.next;
        // 返回虚拟头节点的下一个节点，即为最终的结果链表
    }

}

/**
 * 单链表的定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
思路解析：
1. 创建一个虚拟的头节点  dummy  和一个指针  current ，初始时指向虚拟头节点。这样可以方便地操作链表。
2. 创建一个变量  carry  用于存储进位值，初始为0。
3. 使用循环遍历两个链表，直到两个链表都遍历完。
4. 在每次循环中，获取当前节点的值，如果节点为空则取0。
5. 计算当前节点的和，包括进位值和两个节点的值。
6. 更新进位值，将和除以10并取整。
7. 创建一个新节点，存储当前节点的个位数。
8. 将指针  current  移动到下一个节点。
9. 将两个链表的指针都向后移动一位。
10. 如果最后还有进位值，创建一个新节点存储进位值。
11. 返回虚拟头节点的下一个节点，即为最终的结果链表。
*/