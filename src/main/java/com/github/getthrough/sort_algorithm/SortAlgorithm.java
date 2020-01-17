package com.github.getthrough.sort_algorithm;

/**
 * 排序算法接口
 *
 * @author getthrough
 * @date 2020-01-17
 */
public interface SortAlgorithm {

    /**
     * 排序方法。将一个长度大于 1 的 int 数组，按照从小到大顺序排列。
     *
     * @param toBeSortedArr
     */
    void sort(int[] toBeSortedArr);

}
