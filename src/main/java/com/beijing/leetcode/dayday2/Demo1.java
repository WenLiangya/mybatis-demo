package com.beijing.leetcode.dayday2;

/**
 * [*合并两个有序链表*:
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/1 20:50]
 */
public class Demo1 {
    public static void main(String[] args) {
        //创建两个链表
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;

        //合并两个链表
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(list1, list4);
        //打印合并后的链表
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

/**
 * 递归解法
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //递归解法
        //思路：递归的终止条件是两个链表都为空，如果两个链表有一个为空，那么合并后的链表就是另一个链表
        //先比较两个链表的头节点，小的那个节点就是合并后的头节点，然后递归的调用函数去合并剩余的节点
        //最后返回合并后的头节点

        //递归的终止条件是两个链表都为空
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //先比较两个链表的头节点，小的那个节点就是合并后的头节点
        if (list1.val <= list2.val) {
            //递归的调用函数去合并剩余的节点,最后返回合并后的头节点
            list1.next = mergeTwoLists(list1.next, list2);
            //为什么是list1.next = mergeTwoLists(list1.next, list2);而不是list1 = mergeTwoLists(list1.next, list2);
            //因为list1是一个局部变量，当list1.next = mergeTwoLists(list1.next, list2);
            // 执行完后，list1的值并没有改变，只是list1.next的值改变了
            //所以需要将list1.next = mergeTwoLists(list1.next, list2);赋值给list1.next
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

/**
 * 暴力解法
 */
class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //思路：新建一个链表，然后比较两个链表的值，小的放到新链表中，
        // 然后指针后移，直到其中一个链表为空，然后将另一个链表的剩余部分放到新链表中,最后返回新链表

        //新建一个链表
        ListNode head = new ListNode();
        //新链表的指针
        ListNode cur = head;
        //两个链表的指针
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        //比较两个链表的值，小的放到新链表中，然后指针后移，直到其中一个链表为空
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            //新链表的指针后移
            cur = cur.next;
        }
        //将另一个链表的剩余部分放到新链表中
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return head.next;
    }
}

/**
 * 单链表的定义
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
