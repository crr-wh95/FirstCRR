package com.chengruirun.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
    }

    //希尔排序
    public static void shellSort(int[] arr){
        //第一轮 希尔排序
        //第一轮排序 把10哥数据分成了5组
        int temp = 0;
        for(int gap = arr.length/2;gap>0;gap/=2){
            for(int i = gap;i<arr.length;i++){
                //遍历各组中的所有元素 （共gap组 ） 步长gap
                for(int j = i-gap ; j >= 0;j -= gap){
                    if(arr[j]>arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
//优化后的希尔排序算法
    public static void shellSort2(int[] arr){
        for(int gap = arr.length/2; gap>0 ;gap/=2 ){
            for(int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && temp<arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
