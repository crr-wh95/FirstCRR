package com.chengruirun.stack;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式  逆波兰表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式
        //说明
        //1. 1+((2+3)*4)-5 ====>>>>  1 2 3 + 4 * +5 -
        //2. 用中缀的顺序 放入 到 List中 方法操作 ArrayList[1,+,(,2,+,3,+,),* ,4,),-,5]
        //3.将得到的中缀表达式对应的List =>后缀表达式对应的List
        //  即 ArrayList [1,+,(,2,+,3,+,),* ,4,),-,5] ===>[1,2,3,+,4,*,+,5,-]
        String expression = "9/((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式：" +infixExpressionList);
        List<String> list = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的集合：" + list);
        int i = calculate(list);
        System.out.println("计算的结果：" + i);

/*
        //先定义逆波兰表达式InfixExpressionList
        //为了方便 数字和符号 用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1.先将"3 4 + 5 * 6 -"放到ArrayList里面
        //2.将ArrayList传递给一个方法 配合栈 完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        int i = calculate(rpnList);
        System.out.println(i);
        */
    }

    //  即 ArrayList [1,+,(,2,+,3,+,),* ,4,),-,5] ===>[1,2,3,+,4,*,+,5,-]
    //将得到的中缀表达式对应的List =>后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<>(); // 符号栈
        //Stack<String> s2 = new Stack<>(); // 存放中间结果的栈
        //说明：因为S2这个栈，在整个转化的过程中，没有POP操作，而且后面我们还需要逆序输出
        //所以直接用ArrayList更方便
        List<String> s2 = new ArrayList<>();
        //遍历
        for (String item : ls) {
            //如果是一个数 就加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是 ")"，则依次弹出s1栈顶的运算符 ，并压入S2。直到遇到左括号位置，
                //此时丢弃这一对括号
                while ( !s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); ////!!!! 消除括号 弹出小括号
            }else {
                //当item的优先级 小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到S2中，
                //再次转到（4.1）与S1中的新的栈运算符比较
                while (s1.size() !=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                 s1.push(item);
            }
        }
        //将S1中剩余的运算符依次弹出并加入到S2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2; //因为存放到list中，顺序输出就是对应的后缀表达式
    }

    //方法：将中缀表达式装变成对应的List
    //s = "1+((2+3)*4)-5"
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0 ; //指针 用于遍历中缀表达式
        String str; //多位字符串的拼接
        char c;   //每次遍历一个字符 就放入到C
        do{
            //如果C是一个非数字，需要加入到ls
            if( (c=s.charAt(i)) <48 || (c=s.charAt(i)) >57 ){
                ls.add("" + c);
                i++;
            }else {
                //如果是一个数 考虑字符串的拼接 考虑多位数
                str = ""; //重置
                while (i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i)) <= 57){
                    str +=c; //拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());
        return ls;
    }

    //将一个逆波兰表达式 依次将数字和运算符放入ArrayListz中
    public static List<String> getListString (String suffxiExpression){
        String[] split = suffxiExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成 逆波兰表达式的运算
    /**
     * 从左到右 扫描  3和4 压入堆栈
     * 遇到运算符 弹出 4和3 ，计算值得7再入栈
     * 将5入栈
     * 接下来是 * 运算符 弹出5和7 计算得到35入栈
     * 将6入栈
     * 最后 - 运算符  计算35-6 得到29
     */
    public static int calculate(List<String> ls){
        //创建栈 一个即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //使用正则表达式取出数
             if(item.matches("\\d+")){ //匹配多位数
                 stack.push(item);  //入栈
             }else {
                 //pop出两个数，并运算，再入栈
                 int num2 = Integer.parseInt(stack.pop()); //先弹出的数
                 int num1 = Integer.parseInt(stack.pop()); //后弹出的数
                 int res = 0;
                 if(item.equals("+")){
                     res =num1 + num2;
                 }else if(item.equals("-")){
                     res = num1 - num2;
                 }else if(item.equals("*")){
                     res =num1 * num2;
                 }else if(item.equals("/")){
                     res =num1 / num2;
                 }else {
                     throw new RuntimeException("运算符有误");
                 }
                 //将res入栈
                 stack.push(res + "");
             }
        }
        //留在stack中数据就是最后的结果
        return Integer.parseInt(stack.pop());
    }
}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result =ADD;
                break;
            case "-":
                result =SUB;
                break;
            case "*":
                result =MUL;
                break;
            case "/":
                result =DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
