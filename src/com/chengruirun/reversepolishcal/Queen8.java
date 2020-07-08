package com.chengruirun.reversepolishcal;

public class Queen8 {
    //定义一个MAX表示 总共有多少皇后
    int max = 8;
    //定义一个array,保存皇后放置的结果
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有"+count);
    }

    //编写一个方法，放置第N个皇后
    //每一次递归 都有一次for 循环，所以会有回溯
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for(int i= 0;i<max;i++){
            //先将当前这个皇后N 放到该行的第一列
            array[n] =i;
            //判断当放置第N个皇后到I列时  是否冲突
            if(judge(n)){ //不冲突
                check(n+1); //开始递归了
            }
            //如果冲突的话 其实 再次进入FOR循环。刚才的皇后 在本行后移一位
        }
    }
    //查看我们放置第N个皇后后，就去检测该皇后是否和前面摆放的皇后冲突

    /**
     *
     * @param n 表示第N个皇后
     */
    private boolean judge(int n){

        for(int i = 0 ; i <n;i++){
            //array[i] == array[n]表示在同一列
            //Math.abs(n-i) == Math.abs(array[n])-array[i] 表示在同一条斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //定义一个方法把皇后摆放的位置输出
    private void print(){
        count++;
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
