package com.chengruirun.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //快速排序
     public static void quickSort(int[] arr,int left,int right){
        int l = left; //左下标
        int r = right;  //右下标
        //priot 中轴
         int pivot = arr[(left + right) / 2];
         int temp = 0;
         //while的目的是为了把pivot值小的放到左边
         //比它大的放到右边
         while(l<r){
             //在pivot的左边一直找 摘到大于等于pivot的值 才退出
             while (arr[l] < pivot){
                 l +=1;
             }
             //在pivot的右边一直找 找到小于等于pivot值 才退出
             while (arr[r]>pivot){
                 r -= 1;
             }
             //如果 l>=r说明pivot的左右的值 已经按照左边全部是小于
             //等于pivot的值 右边都是大于等于的
             if(l >= r){
                 break;
             }
             temp = arr[l];
             arr[l] = arr[r];
             arr[r] =temp;
              //如果l.r交换的数据等于 arr[l]==pivot,说明把中间值往前移了
             //导致l的值永远小于r（r会一直不变）的值  所以加了if判断，让r前移动
             //使 l == r 调出循环
             //如果交换完 发现arr[l] == pivot r--,前移
             if(arr[l] == pivot){
                 r -=1;
             }
             //如果交换完 发现arr[r] == pivot l++,后移
             if(arr[r] == pivot){
                 l +=1 ;
             }
         }
         //如果l == r，必须l++,r--,否则会发生栈溢出
         if(l == r){
             l += 1;
             r -= 1;
         }
         if(left < r) {
             quickSort(arr, left, r);
         }
         if (right>l){
             quickSort(arr,l,right );
         }
     }
}
