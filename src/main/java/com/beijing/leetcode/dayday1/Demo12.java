package com.beijing.leetcode.dayday1;

import java.util.ArrayList;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/31 21:32]
 */
public class Demo12 {
}

class Solution12 {
    public void reorderList(ListNode12 head) {
        //给定一个单链表 L 的头节点 head,请将其重新排列：
        //把链表存储到线性表中，然后用双指针依次从头尾取元素即可
        //1.将链表存储到线性表中
        //2.双指针依次从头尾取元素
        //3.将取出的元素串联起来

        ArrayList<ListNode12> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        //双指针依次从头尾取元素,将取出的元素串联起来
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        //这一步很重要，不然会出现环,因为最后一个元素的next指向了前一个元素,所以要将最后一个元素的next指向null
        list.get(left).next = null;
    }
}


/**
 * 单链表的定义
 */
class ListNode12 {
    int val;
    ListNode12 next;

    ListNode12() {
    }

    ListNode12(int val) {
        this.val = val;
    }

    ListNode12(int val, ListNode12 next) {
        this.val = val;
        this.next = next;
    }
}