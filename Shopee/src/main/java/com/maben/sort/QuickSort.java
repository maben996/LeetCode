package com.maben.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 33, 411, 5,15};
        QKSort(a, 0, a.length - 1);
    }

    private static void QKSort(int[] a, int start, int end) {
        // 处理特殊情况
        if (a.length < 1 || start >= end) {
            return;
        }
        // 记录左右游标
        int left = start;
        int right = end;
        // 取左边第一位 为中轴数，
        int tmp = a[left];
        while (left < right) {  //当左右游标相遇时，一次轮排序结束
            // 从右边开始小于中轴数的放在左侧的位置
            while (left < right && a[right] >= tmp) {
                right--;
            }
            a[left] = a[right];
            // 从左边开始大于中轴数的放在右侧的位置
            while (left < right && a[left] <= tmp) {
                left++;
            }
            a[right] = a[left];
        }
        // 此时将中轴数放入到左右游标相遇的位置
        a[left] = tmp;
        // 至此中轴数左侧的数小于中轴数，右侧的数大于中轴数
        System.out.println(Arrays.toString(a));
        // 分治思想，中轴数将元数组一份为二
        // 递归调用，分别对左右两边的数组进行同样的处理，直至排序完成
        QKSort(a, start, left - 1);
        QKSort(a, left + 1, end);
    }
}
