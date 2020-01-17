package com.github.getthrough.sort_algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author getthrough
 * @date 2020-01-14
 */
@Slf4j
public class SortAlgorithmTest {

    private int[] arr = new int[10];

    @Before
    public void produceArr() {

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }

        log.info("init arr is : {}", Arrays.toString(arr));

    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest() {
        SortAlgorithm sortAlgorithm = new BubbleSort();
        sortAlgorithm.sort(arr);
        log.info("after bubble sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 选择排序测试
     */
    @Test
    public void selectionSortTest() {
        SortAlgorithm sortAlgorithm = new SelectionSort();
        sortAlgorithm.sort(arr);
        log.info("after selection sort, arr is : {}", Arrays.toString(arr));
    }

    /**
     * 插入排序测试
     */
    @Test
    public void insertionSortTest() {
        SortAlgorithm sortAlgorithm = new InsertionSort();
        sortAlgorithm.sort(arr);
        log.info("after insertion sort, arr is : {}", Arrays.toString(arr));
    }

}
