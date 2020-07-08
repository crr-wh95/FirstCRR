package com.chengruirun.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
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
                    circleArray.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输出一个数");
                    int i1 = scanner.nextInt();
                    circleArray.add(i1);
                    break;
                case 'g'://取出数据
                    try {
                        int i2 = circleArray.get();
                        System.out.printf("取出的数据%d\n",i2);
                    } catch (Exception E) {
                        E.getMessage();
                    }
                    break;
                case 'h':
                    try{
                        int i3 = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n",i3);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
            }
        }
    }
}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列满的条件
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列为空的条件
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void add(int n){
        //判断队列是否满了
        if(isFull()){
            System.out.println("队列满了不能加");
        }
        arr[rear] = n;
        //将rear后移 考虑模的情况
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据 取数据
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空 不能取");
        }
        //需要分析出front指向第一个元素
        //1.先把front值 保留到一个临时变量中
        //2.front后移
        int value = arr[front];
        front = (front+1) % maxSize;
        return value ;
    }
    //显示 队列的数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i = front;i < front+size();i++){
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    public int size(){
        return (rear + maxSize -front) %maxSize;
    }
    //显头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空 看不到");
        }
        return arr[front ];
    }
}
