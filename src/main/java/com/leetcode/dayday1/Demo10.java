package com.leetcode.dayday1;


import java.util.HashSet;
import java.util.Set;

/**
 * [*环形链表*:
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/31 20:41]
 */
public class Demo10 {
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
        Solution10 solution10 = new Solution10();
        boolean result = solution10.hasCycle(head);
        System.out.println(result);

        // Solution10_1 solution10_1 = new Solution10_1();
        // boolean result1 = solution10_1.hasCycle(head);
        // System.out.println(result1);
    }
}

class Solution10 {
    public boolean hasCycle(ListNode12 head) {
        // 思路：
        // 1.快慢指针
        // 2.快指针一次走两步，慢指针一次走一步
        // 3.如果快指针和慢指针相遇，说明有环
        // 4.如果快指针走到了null，说明没有环
        if (head == null || head.next == null) {
            return false;
        }
        // 定义快慢指针
        ListNode12 left = head.next;
        ListNode12 right = head.next.next;
        // 快慢指针,快指针一次走两步，慢指针一次走一步,如果快指针和慢指针相遇，说明有环
        while (left != null && right != null && right.next != null) {
            // 为什么要判断right.next != null,因为right.next.next会报空指针异常
            if (left == right) {
                return true;
            }
            left = left.next;
            right = right.next.next;
        }
        return false;
    }
}

/**
 * 单链表的定义
 */
class ListNode {
    int val;
    ListNode12 next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}

class Solution10_1 {
    public boolean hasCycle(ListNode12 head) {
        // 思路：
        //1.创建set集合,用来存储节点
        //2.遍历链表
        //3.如果节点重复,说明有环
        //4.如果节点不重复,说明没有环

        //1.创建set集合,用来存储节点
        Set<ListNode12> set = new HashSet<>();
        while (head != null) {
            //如果重复出现说明有环
            if (set.contains(head)) {
                return true;
            }
            //否则就把当前节点加入到集合中
            set.add(head);
            head = head.next;
        }
        return false;
    }
}