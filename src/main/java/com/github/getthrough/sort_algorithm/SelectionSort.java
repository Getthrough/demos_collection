package com.github.getthrough.sort_algorithm;

/**
 * 选择排序算法实现
 * <pre>
 * 基本思路：第一次找到数组中最小的数，与第一个数交换；第二次找到剩余元素中最小的数，与第二个交换，以此类推
 * 性质：
 *      时间复杂度：O(n2)
 *      空间复杂度：O(n)
 *      原地排序
 *      稳定排序
 *
 * @author getthrough
 * @date 2020-01-15
 */
public class SelectionSort implements SortAlgorithm {

    public void sort(int[] toBeSortedArr) {

        int temp;
        // 外层循环控制计算次数
        for (int i = 0; i < toBeSortedArr.length - 1; i++) {
            int min = i;
            // 内层循环选择最小值
            for (int j = i + 1; j < toBeSortedArr.length; j++) {
                if (toBeSortedArr[j] < toBeSortedArr[min]) {
                    // 记录最小值索引位置
                    min = j;
                }
            }
            if (min != i) {
                temp = toBeSortedArr[i];
                toBeSortedArr[i] = toBeSortedArr[min];
                toBeSortedArr[min] = temp;
            }
        }

    }

}
