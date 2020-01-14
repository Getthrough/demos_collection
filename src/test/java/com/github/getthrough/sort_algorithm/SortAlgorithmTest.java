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
        BubbleSort.sort(arr);
        log.info("after bubble sort, arr is : {}", Arrays.toString(arr));
    }

}
