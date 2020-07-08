package com.chengruirun.linkedlist01;

public class SingleLinkedListTest01 {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "压缩", "托儿索");
        HeroNode hero2 = new HeroNode(3, "盲僧", "瞎子");
        HeroNode hero3 = new HeroNode(2, "劫", "儿童劫");
        HeroNode hero4 = new HeroNode(4, "瑞兹", "光头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
        HeroNode newHeroNode = new HeroNode(2,"梦魇","noc");
        singleLinkedList.updata(newHeroNode);
        System.out.println("修改后的");
        singleLinkedList.list();

        singleLinkedList.del(1);
        System.out.println("删除后的");
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//flag标记添加的编号是否存在 默认为false
        while (true) {
            if (temp.next == null) {
                break; //说明temp在链表的最后
            } else if (temp.next.no > heroNode.no) {
                break;//位置找到就在temp后面插入
            } else if (temp.next.no == heroNode.no) {
                flag = true;  //说明编号存在
                break;
            }
            temp = temp.next;// 后移 遍历当前链表
        }
        //判断flag的值
        if (flag) {
            System.out.println("说明编号存在 不能添加");
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
    public void updata(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;    //这个时候相当于指针  第一个元素
        boolean flag = false; //表示是否找到该节点
        while (true){
            if(temp == null){
                break;//到了链表的尾部
            }
            if(temp.no == newHeroNode.no){
                System.out.println("找到了");
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{//第一种情况 flag还是false
            System.out.println("没有找到此编号的节点");
        }
    }
    //删除元素
    public void del(int n){
        HeroNode temp = head;
        boolean flag = false; //表示找到元素没有
        while(true){
            if(temp.next == null){ //到了链表最后
                break;
            }else if(temp.next.no == n){
                System.out.println("找到了要删除的元素");
                flag =true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到要删除的元素");
        }
    }

    //遍历链表
    public void list() {
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
}

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
