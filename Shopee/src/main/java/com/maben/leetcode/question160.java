package com.maben.leetcode;


/**
 * 编写一个程序，找到两个单链表相交的起始节点
 */
public class question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmp1 = headA, tmp2 = headB;
        while (tmp1 != tmp2) {
            tmp1 = tmp1 == null ? headB : tmp1.next;
            tmp2 = tmp2 == null ? headA : tmp2.next;
        }
        return tmp1;
    }

    /**
     * pA:1->2->3->4->5->6->null->9->5->6->null
     * pB:9->5->6->null->1->2->3->4->5->6->null
     * 两个链表分别连起来（当一个走完时，指向另一个的head），如果链表相交则结尾一定有一段相同，同事遍历链表，出现相同节点返回即可
     */
}
