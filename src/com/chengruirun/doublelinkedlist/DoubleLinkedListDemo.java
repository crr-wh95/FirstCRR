package com.chengruirun.doublelinkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "压缩", "托儿索");
        HeroNode2 hero2 = new HeroNode2(3, "盲僧", "瞎子");
        HeroNode2 hero3 = new HeroNode2(2, "劫", "儿童劫");
        HeroNode2 hero4 = new HeroNode2(4, "瑞兹", "光头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add1(hero1);
        doubleLinkedList.add1(hero2);
        doubleLinkedList.add1(hero3);
        doubleLinkedList.add1(hero4);
        doubleLinkedList.list();
        HeroNode2 newHreoNode = new HeroNode2(3, "卡牌", "TF");
        doubleLinkedList.updata(newHreoNode);
        System.out.println("修改后的");
        doubleLinkedList.list();
        //       doubleLinkedList.del(3);
        //     System.out.println("删除后的");
        //   doubleLinkedList.list();


    }
}

//创建双链表的类
class DoubleLinkedList {
    //设置一个头节点 不能动 不能变
    private static HeroNode2 head = new HeroNode2(0, "", "");

    //获取头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //temp向后移动一位 达到遍历
            temp = temp.next;
        }
    }

    //添加数据到双向链表尾部
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        //双向链表 满的情况
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while 循环时 退出链表的最后
        //形成一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //链表的修改
    public void updata(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;  //默认该节点时不存在的
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == heroNode2.no) {
                System.out.println("找到了");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;
        } else {
            System.out.println("没有找到");
        }
    }

    public void del(int n) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false; //默认没有找到元素
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == n) {
                System.out.println("找到了");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没找到");
        }
    }

    public void add1(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        boolean flag = false;  //flag标记添加的编号是否存在 默认为false
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no > heroNode2.no) {  //在temp后插入
                break;
            } else if (temp.next.no == heroNode2.no) {
                System.out.println("说明编号存在");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号存在");
        }
        heroNode2.next = temp.next;
        if(temp.next!= null){
            temp.next.pre = heroNode2;
        }
        temp.next=heroNode2;
        heroNode2.pre =temp.next;

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;   //指向下一个节点 默认为空
    public HeroNode2 pre;    //指向下一个节点

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
