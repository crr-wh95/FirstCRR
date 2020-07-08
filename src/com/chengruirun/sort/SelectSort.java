package com.chengruirun.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
        System.out.println("排序后的：" + Arrays.toString(arr));
    }

    //选择排序
    //第一轮
    //原始数组：101，34，119，1
    //第一轮排序：1，34，119，101
    //算法  先简单--》复杂 （复杂擦拆分为简单的问题）--》逐步解决
    public static void selectSort(int[] arr) {


        /**
         * 第一轮
         int minIndex = 0;  //最小值的下标
         int min = arr[0];  //假定的最小值
         for(int j = 1;j<arr.length;j++){
         if(arr[j] < min){
         min = arr[j];
         minIndex = j;
         }
         }
         //将最小值 放到arr[0]的位置 即交换
         arr[minIndex] = arr[0];
         arr[0] = min;
         System.out.println("第一轮--");
         System.out.println(Arrays.toString(arr));

         第二轮
         int minIndex = 1;  //最小值的下标
         int min = arr[1];  //假定的最小值
         for(int j = 1;j<arr.length;j++){
         if(arr[j] < min){
         min = arr[j];
         minIndex = j;
         }
         }
         //将最小值 放到arr[0]的位置 即交换
         arr[minIndex] = arr[1];
         arr[1] = min;
         System.out.println("第二轮--");
         System.out.println(Arrays.toString(arr));
         */

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {    //如果这里是min < arr[j]就是从大到小排序了
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
}
