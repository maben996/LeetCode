package com.maben.leetcode;

import java.util.HashMap;

public class question138 {
    public static void main(String[] args) {
    }

    public static Node copyRandomList(Node head) {
        //创建一个哈希表，key是原节点，value是新节点
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        //将原节点和新节点放入哈希表中
        while (p != null) {
            Node clone = new Node(p.val);
            map.put(p, clone);
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        while (p != null) {
            Node clone = map.get(p);
            //p是原节点，map.get(p)是对应的新节点，p.next是原节点的下一个节点
            //map.get(p.next)是新节点对应的下一个节点
            if (p.next != null) clone.next = map.get(p.next);
            //p是原节点，map.get(p)是对应的新节点，p.random是原节点指向的随机节点
            //map.get(p.random)是新节点对应的对应指向的随机节点
            if (p.random != null) clone.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
