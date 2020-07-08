package com.chengruirun.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        //第一轮 {101,34,119,1}; -->{34,101,119,1}
        //定义待插入的数
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            //给insertVal 找到插入的位置
            //1.  保证不越界
            //2.insertVal < arr[insertIndex] 待插入的数，还没有找到插入的位置
            //3.这个时候 将 insertIndex 后移动
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; //arr[insertIndex]后移
                insertIndex--;
            }
            //退出while循环时 说明插入的位置 找到了 insertIndex + 1;
            arr[insertIndex + 1] = insertVal;
          //  System.out.println("第一轮插入后：")
        }
    }
}
