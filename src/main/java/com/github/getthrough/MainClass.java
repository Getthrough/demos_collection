package com.github.getthrough;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author getthrough
 * @date 2019-10-28
 */
public class MainClass {

    public static void main(String[] args) {

//        testOutOfMemeoryInHeap();

        MainClass obj = new MainClass();
        obj.testOutOfMemoryInMetaspace();
    }

    static class OOMObject {

    }

    /**
     * 测试堆内存溢出
     * VM options:
     * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
     */
    private static void testOutOfMemeoryInHeap() {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    /**
     * 测试元数据区溢出 FAILED
     * VM options:
     * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
     */
    private void testOutOfMemoryInMetaspace() {
        MainClass mainClass = new MainClass();
        mainClass.testOutOfMemoryInMetaspace();
    }

    @Test
    public void testEquals() {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }

}
