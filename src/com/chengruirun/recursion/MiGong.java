package com.chengruirun.recursion;

public class MiGong {
    public static void main(String[] args) {
        //地图
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
        setWay(map,1,1);
        //输出新的地图  小球走过  并标识过的地图
        System.out.println("小球走过的----");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
    }
    //使用递归回溯给小球找路
    //说明
    //1.map表示地图
    //2.i j 表示从地图的哪个位置开始出发（1，1）
    //3.如果小球找到mqp[6][5]位置 说明找到
    //4.约定：当map[i][j]为0表示还没走过 1为墙  2表示可以走 3表示走过但是走不通
    //5。在走迷宫时 需要确定一个策略(方法)
    //下-->右-->上-->左 如果该点走不通再回溯
    /**
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路  就返回true 否则 false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //通路找到
            return true;
        } else {
            if (map[i][j] == 0) {//表示当前这个点还没走过
                //按照策略下->右->上->左
                map[i][j] = 2; //假定这个点可以走通
                if (setWay(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                }else {
                    //说明这个点走不通
                    map[i][j] =3;
                    return false;
                }
            }else {
                return false;  //因为map不等于0 只能 1 2 3
                               //1表示墙不考虑  2是上面的代码已经标记的绿点 没必要再走
                               //3是死路 也不考虑
            }
        }
    }
}

