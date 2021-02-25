package com.maben.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两数相加
 */
public class question2 {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0); // 初始化游标pre，并固定pre位置
        ListNode res = pre; // 初始化游标res
        if (l1.val == 0 && l2.val == 0) {
            return res;
        }
        int carry = 0;
        while (l1 != null || l2 != null) { // 当本轮两个链表的节点都为null，则跳出
            // 若哪一链表的节点为null，则补0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry; // 加上进位数
            carry = sum > 9 ? 1 : 0; // 计算是否进位
            res.next = new ListNode(sum % 10); // 计算下一位
            res = res.next; // 移动游标
            // 下一轮
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) // 跳出后若还有进位，则新增一个值为1的节点，移动res游标进行拼接
            res = res.next = new ListNode(1);

        // 返回初始右边往后的所有节点
        return pre.next;
    }
}
