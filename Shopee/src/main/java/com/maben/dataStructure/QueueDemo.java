package com.maben.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();

        // Add element
        queue.add(1); // O(1)
        queue.offer(2);
        queue.add(3);
        System.out.println(queue.toString());

        // Get the head of queue
        int tmp1 = queue.peek(); //O(1)
        System.out.println(tmp1);

        // Remove the head of queue
        int tmp2 = queue.remove(); //O(1)
        System.out.println(tmp2);
        System.out.println(queue.toString());

        // Queue is empty
        System.out.println(queue.isEmpty()); // O(1)

        // The length of queue
        System.out.println(queue.size()); // O(1)

        // traverse queue
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.println(tmp);
        }


    }

}

