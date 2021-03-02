package com.maben.leetcode;

import java.util.HashMap;

/**
 * 实现LRUCache
 */
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {this.key= key; this.value = value;}
    }

    private HashMap<Integer,DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部节点和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        // 如果key存在，将node移动到链表的头部（head之后）
        removeToHead(node);
        addToHead(node);
        return node.value;
    }

    /**
     * 存入key-value，如果key存在则更新value，并移动该node节点到链表头部，
     * 如果key不存在，则新增一个值为value的node到链表头部，
     * 检查链表长度是否超出capacity，超出则删除链表最后一个node
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            // 将node移动到链表的头部（head之后）
            removeToHead(node);
            addToHead(node);
        } else {
            // key 不存在，则创建node，存入hash表
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 将新node移动到链表的头部（head之后）
            addToHead(newNode);
            ++size;
            // 如果超出缓存容量，则去除掉最后一个node
            if (size > capacity) {
                // 从hash表中删除最后一个node的key
                cache.remove(tail.prev.key);
                // 从链表中去除最后一个node
                removeToHead(tail.prev);
                --size;
            }
        }
    }

    /**
     * 将node添加到链表的头部（head之后）
     * @param node
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 将node从链表中去掉
     */
    private void removeToHead(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}

