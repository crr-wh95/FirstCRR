package com.chengruirun.queue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):遍历队列");
            System.out.println("h(head):显示列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输出一个数");
                    int i1 = scanner.nextInt();
                    arrayQueue.add(i1);
                    break;
                case 'g'://取出数据
                    try {
                        int i2 = arrayQueue.get();
                        System.out.printf("取出的数据%d\n",i2);
                    } catch (Exception E) {
                        E.getMessage();
                    }
                    break;
                case 'h':
                    try{
                        int i3 = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",i3);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
            }
        }
    }
}

class ArrayQueue {
    private int maxSize;  //数组最大容量
    private int front;  //队列头
    private int rear;   //队列尾
    private int[] arr;  // 存储数据的   模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头的前一个位置
        rear = -1; //指向队列为 包含最后一个
    }

    //判断队列满的条件
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列为空的条件
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满了不能加");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //获取队列数据

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 看不到");
        }
        return arr[front + 1];
    }
}
