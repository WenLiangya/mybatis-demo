package com.leetcode.dayday2;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/6 20:36]
 */
public class Demo2 {
    public static void main(String[] args) {
        ListNode2 list1 = new ListNode2(1);
        ListNode2 list2 = new ListNode2(2);
        ListNode2 list3 = new ListNode2(3);
        ListNode2 list4 = new ListNode2(4);
        ListNode2 list5 = new ListNode2(5);
        ListNode2 list6 = new ListNode2(6);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;

        Solution2 solution2 = new Solution2();

        ListNode2 result = solution2.swapPairs(list1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class Solution2 {
    public ListNode2 swapPairs(ListNode2 head) {
        //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
        // 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
        // 递归
        // 1. 递归终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了。
        // 2. 调用单元：从链表的头节点 head 开始递归，head 的下一个节点是 head.next。
        // 3. 返回值：交换了两个节点以后，返回交换后的头节点，即 head.next。
        // 4. 本级递归应该做什么：如果链表只有两个节点，那么在完成它们的交换之后，还需要将原链表中
        // 的头节点指向交换后的头节点，即 head.next，同时将交换后的节点的下一个节点指向交换前的头节点 head。
        // 5. 由于递归会将链表以从头节点开始，每两个节点为一组进行分组，因此对于链表中的其余节点也需要如此交换，
        // 而且每一组中的第二个节点都是下一组的头节点。因此，需要将每一组的头节点连接起来。
        // 6. 最后返回新的头节点即可。
        // 时间复杂度：O(n)，其中 n 是链表的节点数量。需要对每个节点进行更新指针的操作。
        // 空间复杂度：O(n)，其中 n 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间。

        // 递归终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了。
        if (head == null || head.next == null) {
            return head;
        }
        // 调用单元：从链表的头节点 head 开始递归，head 的下一个节点是 head.next。
        ListNode2 next = head.next;
        // 递归
        head.next = swapPairs(next.next);
        next.next = head;
        // 由于递归会将链表以从头节点开始，每两个节点为一组进行分组，因此对于链表中的其余节点也需要如此交换，
        // 而且每一组中的第二个节点都是下一组的头节点。因此，需要将每一组的头节点连接起来。
        // 最后返回新的头节点即可。
        return next;
    }
}

// Definition for singly-linked list
class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}