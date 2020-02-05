package com.github.getthrough.string_operation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author getthrough
 * @date 2020-02-05
 */
@Slf4j
public class StringOperatorTest {

    /**
     * 测试获取给定字符串中对称的所有最长子字符串
     */
    @Test
    public void getLongestSymmetricalStringTest() {
        // String s = "eabgbdcae";
        // String s = "abdadbdc";
        // String s = "google";
        String s = "ab`c`ba";
        // String s = "abcda";
        log.info("raw string is : {}", s);
        List<String> longestSymmetricalStrings = StringOperator.getLongestSymmetricalString(s);
        log.info("longest symmetrical string(s) is(are) : {}", longestSymmetricalStrings);

    }

}
