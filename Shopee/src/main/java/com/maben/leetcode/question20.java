package com.maben.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class question20 {
    public static void main(String[] args) {
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

}
