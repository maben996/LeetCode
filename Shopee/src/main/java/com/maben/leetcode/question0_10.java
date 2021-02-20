package com.maben.leetcode;


import java.util.*;

public class question0_10 {
    public static void main(String[] args) {
        //1.两数之和q
//        int[] nums = {1, 2, 7};
//        twoSum1(nums, 9);
//        twoSum2(nums,9);
        //20.有效的括号
        boolean vaild = isVaild2("{}()");

    }

    public static boolean isVaild2(String s) {
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isVaild1(String s) {
        boolean flag = false;
        while (!flag) {
            int len1 = s.length();
            s = s.replace("[]", "")
                    .replace("{}", "")
                    .replace("()", "");
            int len2 = s.length();
            if (len2 == len1) {
                return flag;
            }
            if (len2 == 0) {
                flag = true;
            }
        }
        return flag;
    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

