package com.github.getthrough.string_operation;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串操作工具类
 *
 * @author getthrough
 * @date 2020-02-05
 */
@Slf4j
public final class StringOperator {

    /**
     * 返回给定字符串中最长的对称子字符串。
     * <pre>
     * 题目为：
     *      输入一个字符串s，我们可以删除字符串s中的任意字符，让剩下的字符串形成一个对称字符串，且该字符串为最长对称字符串。
     *      如：输入google，则找到最长对称字符串为goog；如输入abcda则能找到3个最长对称字符串为aba/aca/ada。
     *      若最长对称字符串存在多个，则输出多个相同长度的最长对称字符串，且字符串中不包含特殊字符。
     * 整体思路为：
     *      1. 获取
     * </pre>
     *
     * @param s
     * @return
     */
    public static List<String> getLongestSymmetricalString(String s) {
        if (s == null || s.length() == 0 || getStringLettersCount(s) == 1)
            return s == null ? Collections.emptyList() : Arrays.asList(s);

        List<String> symmetricalStrings = new ArrayList<>();

        // 从字符串左侧开始查找对称字符，left 为左侧游标
        for (int left = 0; left < s.length(); left++)
            getSymmetricalStrings(s, left, symmetricalStrings);

        log.info("all symmetrical strings are : {}", symmetricalStrings);

        // 所有对称字符串中最长的字符串
        return getLongestString(symmetricalStrings);
    }

    /**
     * 获取集合中最长的字符串
     *
     * @param symmetricalStrings
     * @return
     */
    private static List<String> getLongestString(List<String> symmetricalStrings) {
        if (null == symmetricalStrings || symmetricalStrings.size() == 0)
            return Collections.emptyList();

        List<String> longestStringList = new ArrayList<>(symmetricalStrings.size());

        for (String s : symmetricalStrings) {
            if (longestStringList.size() == 0) {
                longestStringList.add(s);
                continue;
            }
            int firstStrLen = getStringLettersCount(longestStringList.get(0));
            // 如果当前字符串长度大于集合中第一个字符串长度
            if (firstStrLen < getStringLettersCount(s)) {
                // 清理集合，重新放入
                longestStringList.clear();
                longestStringList.add(s);
            } else if (firstStrLen == getStringLettersCount(s))
                // 相同长度，直接放入
                longestStringList.add(s);
        }

        return longestStringList;
    }

    /**
     * 获取一个字符串从第 left 个字符索引开始的子串中最长对称子字符串
     *
     * @param s                  原始字符串
     * @param left               字符串左侧开始的索引位置
     * @param symmetricalStrings 存放所有对称字符串的集合
     */
    private static void getSymmetricalStrings(String s, int left, List<String> symmetricalStrings) {
        int len = s.length();

        // 对称字符存放数组
        char[] arr = new char[len];
        // 轮询中发现对称字符的次数，用于对应字符放在数组中的位置
        int count = 0;
        // 右侧游标从字符串末尾开始
        int right = len - 1;
        // 是否存在对称字符
        boolean hasSymmetrical = false;

        // 移动左侧游标
        for (; left <= right; left++) {
            // 获得左侧当前字符
            char l = s.charAt(left);
            // 特殊字符判断
            if (!Character.isLetterOrDigit(l))
                continue;
            // 移动右侧游标
            for (; right > left; right--) {
                if (right == left) {
                    // 如果左右游标重合，表示上一次最后的两个元素肯定不同
                    if (hasSymmetrical)
                        // 如果前面的循环中找到了对称字符，则将当前的元素插进去
                        arr[count] = l;
                    break;
                }
                // 获得右侧当前字符
                char r = s.charAt(right);
                // 特殊字符判断
                if (!Character.isLetterOrDigit(l))
                    continue;

                if (l == r) {
                    // 如果游标上的元素相同，则放置到数组指定位置
                    arr[count] = l;
                    arr[len - 1 - count] = r;
                    // 如果左右相等，则将左和右内每个元素分别于已经对称的元素拼接，形成对称字符串
                    if (right - left > 1) {
                        for (int i = left + 1; i < right; i++) {
                            char c = s.charAt(i);
                            if (!Character.isLetterOrDigit(c))
                                continue;
                            char[] temp = new char[len];
                            System.arraycopy(arr, 0, temp, 0, arr.length);
                            temp[count + 1] = c;
                            addToList(symmetricalStrings, temp);
                        }
                    }
                    ++count;
                    --right;
                    hasSymmetrical = true;
                    break;
                }
            }
        }
        addToList(symmetricalStrings, arr);
    }

    /**
     * 将放置好的字符数组拼装成字符串存入集合
     *
     * @param symmetricalStrings
     * @param arr
     */
    private static void addToList(List<String> symmetricalStrings, char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        String str = sb.toString();
        if (getStringLettersCount(str) > 1 && !symmetricalStrings.contains(str))
            symmetricalStrings.add(str);
    }

    /**
     * 获取字符串中字符的个数
     *
     * @param s
     * @return
     */
    public static int getStringLettersCount(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                ++count;
        }

        return count;
    }

}
