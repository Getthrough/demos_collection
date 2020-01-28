package com.github.getthrough.sort_algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author getthrough
 * @date 2020-01-14
 */
@Slf4j
public class SortAlgorithmTest {

    private static final int PRINT_THRESHOLD = 20;
    private static final int ARR_SIZE = 100_000;
    private int[] arr = new int[ARR_SIZE];

    @Before
    public void produceArr() {

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }

        if (arr.length <= PRINT_THRESHOLD)
            log.info("init arr is : {}", Arrays.toString(arr));

    }

    /**
     * 冒泡排序测试
     * 100w - 1750637 ms
     */
    @Test
    public void bubbleSortTest() {
        long start = System.currentTimeMillis();
        SortAlgorithm sortAlgorithm = new BubbleSort();
        sortAlgorithm.sort(arr);
        log.info("bubble sort took {} ms", System.currentTimeMillis() - start);

        if (arr.length <= PRINT_THRESHOLD)
            log.info("after bubble sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 选择排序测试
     * 100w - 489090 ms
     */
    @Test
    public void selectionSortTest() {
        long start = System.currentTimeMillis();
        SortAlgorithm sortAlgorithm = new SelectionSort();
        sortAlgorithm.sort(arr);
        log.info("selection sort took {} ms", System.currentTimeMillis() - start);

        if (arr.length <= PRINT_THRESHOLD)
            log.info("after selection sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 插入排序测试
     * 100w - 119731 ms
     */
    @Test
    public void insertionSortTest() {
        long start = System.currentTimeMillis();
        SortAlgorithm sortAlgorithm = new InsertionSort();
        sortAlgorithm.sort(arr);
        log.info("insertion sort took {} ms", System.currentTimeMillis() - start);

        if (arr.length <= PRINT_THRESHOLD)
            log.info("after insertion sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 快速排序测试
     * 100w - 90 ms
     */
    @Test
    public void quickSortTest() {
        long start = System.currentTimeMillis();
        SortAlgorithm sortAlgorithm = new QuickSort();
        sortAlgorithm.sort(arr);
        log.info("quick sort took {} ms", System.currentTimeMillis() - start);

        if (arr.length <= PRINT_THRESHOLD)
            log.info("after quick sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 10 w 数组测试结果：
     * <pre>
     *     quick sort :         20 ms
     *     insertion sort :     971 ms
     *     selection sort :     4257 ms
     *     bubble sort :        17243 ms
     * </pre>
     *
     */
    @Test
    public void sortCompareTest() {

        Map<Long, String> timeNameMap = new TreeMap<>((o1, o2) -> o1 <= o2 ? 1 : -1);

        int[] bubbleArr = new int[ARR_SIZE];
        int[] selectionArr = new int[ARR_SIZE];
        int[] insertionArr = new int[ARR_SIZE];
        int[] quickArr = new int[ARR_SIZE];

        System.arraycopy(arr, 0, bubbleArr, 0, arr.length);
        System.arraycopy(arr, 0, selectionArr, 0, arr.length);
        System.arraycopy(arr, 0, insertionArr, 0, arr.length);
        System.arraycopy(arr, 0, quickArr, 0, arr.length);

        long t1 = System.currentTimeMillis();
        // 冒泡耗时
        SortAlgorithm sa = new BubbleSort();
        sa.sort(bubbleArr);
        long t2 = System.currentTimeMillis();
        timeNameMap.put(t2 - t1, "bubble sort");
        sa = new SelectionSort();
        sa.sort(selectionArr);
        long t3 = System.currentTimeMillis();
        timeNameMap.put(t3 - t2, "selection sort");
        sa = new InsertionSort();
        sa.sort(insertionArr);
        long t4 = System.currentTimeMillis();
        timeNameMap.put(t4 - t3, "insertion sort");
        sa = new QuickSort();
        sa.sort(quickArr);
        long t5 = System.currentTimeMillis();
        timeNameMap.put(t5 - t4, "quick sort");

        log.info(timeNameMap.toString());
    }

}
