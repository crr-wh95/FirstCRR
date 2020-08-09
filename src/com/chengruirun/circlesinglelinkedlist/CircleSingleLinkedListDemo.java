package com.chengruirun.circlesinglelinkedlist;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {

    }
}
class CircleSingleLinkedList{
//设置一个first节点 当前没有编号
    private Boy first = null;
    //添加小孩节点 构建成一个环形的链表
    public void addBoy(int nums){
        if(nums < 1 ){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null; //辅助指针 帮助构建环形列表
        for(int i = 1 ; i < nums ;i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成环形
                curBoy = boy;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy =boy;
            }
        }
    }

    public void list(){
        if(first == null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy.getNo());
            if(curBoy.getNext() == first){
                System.out.println("11111111111111");
                break;  //说明遍历完毕
            }
            curBoy=curBoy.getNext();
        }
    }
}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
