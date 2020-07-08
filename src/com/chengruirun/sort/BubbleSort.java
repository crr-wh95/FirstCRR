package com.chengruirun.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度 为  O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        System.out.println("排序前：" +Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：" +Arrays.toString(arr));
    }
    //封装为一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0; //临时变量
        boolean flag = false; //标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (flag == false) {//表示一次交换都没有
                break;
            } else {
                flag = false;//在里面的循环时，假如进行了交换
                // flag的值为true 外循环一定要重置
            }
        }
    }
}
