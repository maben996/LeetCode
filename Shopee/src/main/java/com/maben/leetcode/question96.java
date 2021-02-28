package com.maben.leetcode;

/**
 * BST ： 二叉搜索数
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class question96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; // 当 n=0 时，没有数字，只能形成一种 BST ：空树。
        dp[1] = 1; // 当 n=1 时，只有一个数字，只能形成一种 BST ：单个节点。

        for (int i = 2; i <= n; i++) {  // i 代表遍历 n 的游标，直接从2开始，切小于等于n
            // 分割线j作为根节点时BST的种类数=j节点的左子树BST种类数 * j节点的右子树BST种类数
            for (int j = 1; j < i+1; j++) { // 遍历n个节点中同的节点作为根节点的可能性
                //  dp[j] 代表j的左子树BST种类数，dp[n-1-j]代表j的右子树BST种类数
                dp[i] += dp[j-1] * dp[i-j];   // 其中 += 符号的使用是为了在本次根节点遍历时，加上上一次根节点的值
            }
        }
        return dp[n]; // 最后返回dp[n] 代表n 个节点存在二叉排序树的个数
    }
}
