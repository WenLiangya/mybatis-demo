package com.year2024.leetcode.month1;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2024/1/4 11:44]
 */
public class day4_1 {
    public static void main(String[] args) {
        //生成测试用例
        ListNode4_1 head = new ListNode4_1(3);
        head.next = new ListNode4_1(2);
        head.next.next = new ListNode4_1(0);
        head.next.next.next = new ListNode4_1(-4);
        head.next.next.next.next = head.next;
        System.out.println(new Solution4_1().detectCycle(head).val);
    }
}

/**
 * 142. 环形链表 II
 中等
 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 不允许修改 链表。
 */
class Solution4_1 {
    public ListNode4_1 detectCycle(ListNode4_1 head) {
        // 快慢指针
        ListNode4_1 slow = head;
        ListNode4_1 fast = head;
        // 边界判断，fast.next为空时，没有环
        while (fast != null && fast.next != null) {
            // 快指针每次走两步，慢指针每次走一步
            slow = slow.next;
            fast = fast.next.next;
            //如果快慢指针相遇，则存在环
            if (slow == fast) {
                // 找到环的入口节点，设置flag1为环的入口节点，flag2为慢指针
                //当flag1==flag2时，可以确定环的入口节点flag1
                ListNode4_1 flag1 = head;
                ListNode4_1 flag2 = slow;
                while (flag1 != flag2) {
                    flag1 = flag1.next;
                    flag2 = flag2.next;
                }
                return flag1;
            }
        }
        return null;
    }
}

class ListNode4_1 {
    int val;
    ListNode4_1 next;

    ListNode4_1(int x) {
        val = x;
        next = null;
    }
}