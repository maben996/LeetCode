package com.maben.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question199 {

    public static void main(String[] args) {
//            rightSideView(new TreeNode(1,1))
    }


    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {  // 判空直接返回空list
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 用队列承载每一个一节点，实现 先序遍历 「根结点 -> 左子树 -> 右子树」
        queue.offer(root);  // offer类似于add,队列满时不会跑异常，比add更安全，
        while (!queue.isEmpty()) { // 如果队列为空，代表遍历完成
            int size = queue.size(); // 每次进来之后获取队列的大小，就是当前层的节点数
            for (int i =0; i < size; i++) { // 遍历当前层的节点，将最后一个节点放入结果集res
                TreeNode node = queue.poll(); // 获取当前层第一个节点，配合队列FIFO的特点，实现 先序遍历 「根结点 -> 左子树 -> 右子树」
                if (node.left != null) { // 该节点的左叶子节点有无
                    queue.offer(node.left); // 有则加入队列，等待下一层遍历
                }

                if (node.right != null) { // 该节点的右叶子节点有无
                    queue.offer(node.right); // 有则加入队列，等待下一层遍历
                }
                if (i == size -1) {  // 判断是否为当前层的最后一个节点
                    res.add(node.val); //若是，则将该节点放入结果集res
                }
            }

        }
        return res;
    }
}
