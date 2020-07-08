package com.chengruirun.stack;

public class Calculator {
    public static void main(String[] args) {
        String experssion = "3+2*6-2";
        //创建两个栈 一个符号栈一个运算符栈
        ArrayStack numStrack = new ArrayStack(10);
        ArrayStack operStrack = new ArrayStack(10);
        //定义需要的相关变量
        int index = 0; //用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描的单个结果 保存在char中
        //开始while循环的exoerssion
        while (true) {
            //依次得到experssion的每一个字符
            ch = experssion.substring(index, index + 1).charAt(0);
            //判断ch是什么 然后做相应的处理
            //为符号的时候
            if (operStrack.isOper(ch)) {
                if (!operStrack.isEmpty()) {
                    //如何符号栈有操作符 进行比较 。如果当前的操作符优先级小于或等于栈中的操作符，
                    //需要从数栈中pop出两个数
                    //再从符号栈POP出一个符号 进行运算。
                    //得到的结果入数栈 然后当前的符号入符号栈
                    if (operStrack.priority(ch) <= operStrack.priority(operStrack.peek())) {
                        num1 = numStrack.pop();
                        num2 = numStrack.pop();
                        oper = operStrack.pop();
                        res = numStrack.cal(num1, num2, oper);
                        //将结果入栈
                        numStrack.push(res);
                        operStrack.push(ch);
                    } else {
                        //如果当前的操作符优先级大于栈中的操作符  直接入
                        operStrack.push(ch);
                    }
                } else {
                    //为空直接入符号栈
                    operStrack.push(ch);
                }
            } else { //为数字的时候
                numStrack.push(ch - 48);
            }
            index++;
            if (index >= experssion.length()) {
                break;
            }
        }
        //当表达式扫描完毕 就顺序的从数栈和符号栈 中POP出相应的数和符号 并运行
        while (true) {
            if (operStrack.isEmpty()) {
                break;
            }
            num1 = numStrack.pop();
            num2 = numStrack.pop();
            oper = operStrack.pop();
            res = numStrack.cal(num1, num2, oper);
            numStrack.push(res);
        }
        //将数栈最后的数 POP出来
        System.out.println(res);
    }
}

class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack;//数组 数组模拟栈 数据放在该数组
    private int top = -1; //表示栈顶 初始化为-1

    //构造器
    public ArrayStack() {
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //  栈满的判断
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    public int peek() {
        return stack[top];
    }

    //入栈
    public void push(int value) {
        //先判断是否满了
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 出栈pop 将栈的数据返回
    public int pop() {
        if (isEmpty()) {
            //抛出异常处理
            throw new RuntimeException("栈空没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈 遍历从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空 不能遍历");
            return;
        }
        for (int i = top; i >= 0; i--) {  //动的是i  top永远是不动的
            System.out.println(stack[i]);
        }
    }

    //返回运算符的优先级 优先级是程序员定义 优先级用数字表示
    //数字越大 则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else
            return -1;
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0; //res用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

}
