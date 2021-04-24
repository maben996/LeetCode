package com.maben.leetcode;

/**
 * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
 * 其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question238 {
    public int[] productExceptSelf(int[] nums) {
        // 此方法时间复杂度为O(n2) 官方不推荐
//        int [] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//            for (int j = 0; j< nums.length; j++) {
//                if (i == j) continue;
//                product = product * nums[j];
//            }
//            res[i] = product;
//        }
//        return res;

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R *= nums[i + 1];
            res[i] = res[i] * R;
        }
        return res;
    }
}
