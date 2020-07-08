package com.chengruirun.linkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "压缩", "托儿索");
        HeroNode hero2 = new HeroNode(2, "盲僧", "瞎子");
        HeroNode hero3 = new HeroNode(3, "劫", "儿童劫");
        HeroNode hero4 = new HeroNode(4, "瑞兹", "光头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
        HeroNode lastIndexNode = SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println(lastIndexNode);

    }
}

//定义 SingleLinkedList 来管理 英雄
class SingleLinkedList {
    //初始化一个头节点 什么都别放
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //找到最后一个节点
    //将这个节点的next域指向 添加的节点
    public void add(HeroNode heroNode) {
        //因为头节点不能动 创建一个辅助变量进行操作
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {                   //添加 是  temp = head
                break;
            }
            temp = temp.next;
        }
        temp.next= heroNode;
    }

    //遍历链表
    public void list() {                                 //遍历是      temp = head.next;
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动  因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移  一定小心
            temp = temp.next;
        }
    }

    //找出单链表的节点书
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            System.out.println("空链表");
            return 0;
        }
        HeroNode temp = head.next;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;  //遍历了urn length;
    }

    //查找单链表中 的倒数第K个节点
    //1.编写一个方法，接收head节点 同时接受一个index
    //2.index表示 倒数 第index节点
    //3.先把链表从头到尾遍历 得到链表的总长度 getLength()
    //4.第二次遍历 就是从链表的第一个开始遍历  size - getLength()
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        HeroNode temp = head.next;
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        //第二次遍历
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
}

//定义HeroNode  每一个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
