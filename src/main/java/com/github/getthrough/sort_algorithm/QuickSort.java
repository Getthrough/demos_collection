package com.github.getthrough.sort_algorithm;

/**
 * 快速排序算法实现
 *
 * @author getthrough
 * @date 2020-01-28
 */
public class QuickSort implements SortAlgorithm {

    // 5,3,8,6,4

    @Override
    public void sort(int[] toBeSortedArr) {
        quickSort(toBeSortedArr, 0, toBeSortedArr.length - 1);
    }

    private void quickSort(int[] toBeSortedArr, int left, int right) {
        if (left >= right || toBeSortedArr == null || toBeSortedArr.length <= 1)
            return;

        int i = left;
        int j = right;
        // 基准值
        int pivot = toBeSortedArr[(left + right) / 2];

        while (i <= j) {
            // 如果左侧的值比基准值小，则该值不动，向右移动指针
            while (toBeSortedArr[i] < pivot) {
                ++i;
            }
            // 如果右侧的值比基准值大，则该值不动，向左移动指针
            while (toBeSortedArr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int temp = toBeSortedArr[i];
                toBeSortedArr[i] = toBeSortedArr[j];
                toBeSortedArr[j] = temp;
                ++i;
                --j;
            } else if (i == j)
                ++i;
        }

        quickSort(toBeSortedArr, left, j);
        quickSort(toBeSortedArr, i, right);

    }

}
