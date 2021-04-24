package com.maben.dataStructure;

import java.util.LinkedList;

public class ListNodeDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);    // O(1)
        list.add(2);
        list.add(3);
        System.out.println(list.toString());

        list.add(2,99);
        System.out.println(list.toString());    // O(N)

        // Search element
        int index = list.indexOf(99);   // O(N)
        System.out.println(index);

        // Update element
        list.set(2,88); // O(N)
        System.out.println(list.toString());

        // Remove element
        list.remove(2); // O(N)
        System.out.println(list.toString());

        // Length
        int size = list.size(); //O(1)
        System.out.println(size);
    }
}
