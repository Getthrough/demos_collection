package com.github.getthrough.sort_algorithm;

/**
 * 插入排序算法实现
 * <pre>
 * 基本思想：将每一个值（A）与它前面的值比较，如果前面的值比 A 大，则将前面的值往后挪一位，
 *          循环直到前面的值（B） <= A，将 A 放到 B 后面，完成插入。
 * 性质：
 *      时间复杂度：O(n2)
 *      空间复杂度：O(n)
 *      稳定排序
 *      原地排序
 *
 * @author getthrough
 * @date 2020-01-17
 */
public class InsertionSort implements SortAlgorithm {

    public void sort(int[] toBeSortedArr) {

        // 从第二张开始，轮询每个值
        /*for (int i = 1; i < toBeSortedArr.length; i++) {
            // 拿到当前值
            int toInsert = toBeSortedArr[i];
            // 上一个值
            int j = i - 1;
            // 如果大于要插入的值
            while (j >= 0 && toBeSortedArr[j] > toInsert) {
                // 将此位置的值往后挪
                toBeSortedArr[j + 1] = toBeSortedArr[j];
                // 再向前询问
                --j;
            }
            // 此时 j 位置的值已经比起始值小，将起始值插入到 j 后面
            toBeSortedArr[j + 1] = toInsert;
        }*/

        for (int i = 1; i < toBeSortedArr.length - 1; i++) {
            // 拿到当前值
            int toInsert = toBeSortedArr[i];
            int j = i - 1;
            for (; j >= 0 && toBeSortedArr[j] > toInsert; j--) {
                toBeSortedArr[j + 1] = toBeSortedArr[j];
            }
            toBeSortedArr[j+1] = toInsert;
        }

    }

}
