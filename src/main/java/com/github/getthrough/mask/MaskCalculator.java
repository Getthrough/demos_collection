package com.github.getthrough.mask;

import lombok.extern.slf4j.Slf4j;

/**
 * 口罩计算器类
 * @author getthrough
 * @date 2020-01-28
 */
@Slf4j
public class MaskCalculator {

    /**
     * 假设出门一次消耗一只口罩，若能买到口罩，则一次能买 10 只。在给定初始拥有口罩数量、出门次数
     * 及最终拥有口罩数量情况下，计算其中几次出门买到口罩了
     * @param goOutTimes 出门次数
     * @return 出门买到口罩的次数
     */
    public long calcBoughtMaskTimes(long goOutTimes, long startMasks, long endMasks) {
        log.info("初始拥有口罩 {} 只，结束时拥有口罩 {} 只", startMasks, endMasks);
        return calcBoughtMaskTimes(goOutTimes, endMasks - startMasks);
    }

    /**
     * 假设出门一次消耗一只口罩，若能买到口罩，则一次能买 10 只。在给定初始拥有口罩数量、
     * 一共增加的口罩数量，计算其中几次出门买到口罩了
     * @param goOutTimes 出门次数
     * @param incomeMasks 口罩收益（单位：个）
     * @return 出门买到口罩的次数
     */
    public long calcBoughtMaskTimes(long goOutTimes, long incomeMasks) {
        validParams(goOutTimes);

        // 程序运行次数
        long calcTimes = 0;

        if (goOutTimes == 0L) {
            log.info("计算程序运行了 {} 次", ++calcTimes);
            return 0L;
        }

        long boughtMaskTimes = goOutTimes / 2L;
        long leftEndpoint = 1L;
        long rightEndpoint = goOutTimes;

        while (true) {
            ++calcTimes;
            long tempIncome = boughtMaskTimes * 9 - (goOutTimes - boughtMaskTimes) * 1;
            try {
                if (tempIncome > incomeMasks) {
                    boughtMaskTimes = reindex(leftEndpoint, boughtMaskTimes);
                    rightEndpoint = boughtMaskTimes;
                } else if (tempIncome < incomeMasks) {
                    boughtMaskTimes = reindex(boughtMaskTimes, rightEndpoint);
                    leftEndpoint = boughtMaskTimes;
                } else {
                    log.info("计算程序运行了 {} 次", calcTimes);
                    return boughtMaskTimes;
                }
            } catch (IllegalArgumentException e) {
                log.error("无法得到整数次数，题目有问题！");
                log.warn("错误信息：{}", e);
            }

        }

    }

    /**
     * 重新计算买到次数的索引位置
     * @param leftEndpoint
     * @param rightEndPoint
     * @return
     */
    private long reindex(long leftEndpoint, long rightEndPoint) {
        if (leftEndpoint > rightEndPoint)
            throw new IllegalArgumentException("左端点不能大于右端点！");
        return (leftEndpoint + rightEndPoint) /2L;
    }

    /**
     * 校验参数合法性
     * @param goOutTimes
     */
    private void validParams(long goOutTimes) {

        if (goOutTimes < 0)
            throw new IllegalArgumentException("出门次数不能为负！");

        if(goOutTimes == 0 && goOutTimes != 0)
            throw new IllegalArgumentException("没有出门情况下，口罩收益应为 0 个！");

    }

}
