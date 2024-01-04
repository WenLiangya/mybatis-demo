package com.leetcode.dayday2;

/**
 * [*23.合并k个有序链表*:
 * 给你一个链表数组，每个链表都已经按升序排列,
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/12 21:47]
 */
public class Demo7 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        ListNode[] lists = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        listNode7.next = listNode8;

        lists[0] = listNode1;
        lists[1] = listNode4;
        lists[2] = listNode7;

        ListNode listNode = solution.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}


/**
 * @noinspection DuplicatedCode
 */
class Solution7 {
    /**
     * 合并K个升序链表
     *
     * @param lists 链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //思路：分治法+递归
        //将k个链表配对并将同一对中的链表合并
        //第一轮合并以后，k个链表被合并成了k/2个链表，平均长度为2n/n，然后是k/4个链表，k/8个链表等等
        //重复这一过程，直到我们得到了最终的有序链表
        //因此，我们将会合并logk次，每次合并两个长度为n的链表
        //时间复杂度：O(nlogk) n是所有链表中元素的总和，k是链表的数目
        //空间复杂度：O(1)
        if (lists == null || lists.length == 0) {
            return null;
        }
        //左边界0,右边界lists.length-1
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并链表
     *
     * @param lists 链表数组
     * @param left  左边界
     * @param right 右边界
     * @return 合并后的链表
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        //递归终止条件,左边界==右边界
        if (left == right) {
            return lists[left];
        }
        //递归调用
        int mid = left + (right - left) / 2;//中间位置,防止溢出
        ListNode l1 = merge(lists, left, mid);//左边的链表,递归调用,直到left==right
        ListNode l2 = merge(lists, mid + 1, right);//右边的链表,递归调用,直到left==right
        //合并
        return mergeTwoLists(l1, l2);
    }

    /**
     * 合并两个有序链表
     *
     * @param list1 左链表
     * @param list2 右链表
     * @return 合并后的链表
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
 * [21.合并两个有序链表]
 */
class Solution7_1 {
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