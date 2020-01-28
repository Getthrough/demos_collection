package com.github.getthrough.mask;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author getthrough
 * @date 2020-01-28
 */
@Slf4j
public class MaskCalculatorTest {

    @Test
    public void calcBoughtMaskTimesTest() {
        MaskCalculator mc = new MaskCalculator();
        long boughtTimes = mc.calcBoughtMaskTimes(10, 60);
        log.info("出门买到口罩次数为：{} 次", boughtTimes);
    }

    @Test
    public void calcBoughtMaskTimesTest2() {
        MaskCalculator mc = new MaskCalculator();
        long boughtTimes = mc.calcBoughtMaskTimes(10, 10, 70);
        log.info("出门买到口罩次数为：{} 次", boughtTimes);
    }

}
