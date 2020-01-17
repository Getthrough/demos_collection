package com.github.getthrough.sort_algorithm;

/**
 * 冒泡排序算法实现
 * <pre>
 * 基本思想：两数比较大小，较小的数在前，较大的数在后
 * 性质：
 *      时间复杂度 O(n2)
 *      空间复杂度 O(1)
 *      稳定排序
 *      原地排序
 *
 * @author getthrough
 * @date 2020-01-14
 */
public class BubbleSort implements SortAlgorithm {

    public void sort(int[] toBeSortedArr) {

        int temp;
        // 是否已经排好序
        boolean sorted = true;
        // 外层循环控制冒泡次数（n - 1）
        for (int i = 0; i < toBeSortedArr.length - 1; i++) {
            // 内层循环进行具体相邻交换动作(外层每走一次即确定)
            for (int j = 0; j < toBeSortedArr.length - i - 1; j++) {
                if (toBeSortedArr[j] > toBeSortedArr[j + 1]) {
                    sorted = false;
                    temp = toBeSortedArr[j];
                    toBeSortedArr[j] = toBeSortedArr[j + 1];
                    toBeSortedArr[j+1] = temp;
                }
            }
            if (sorted)
                break;
        }
    }
}
