package dxc.no11_两个单链表生成相加链表;

import dxc.Node;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: AddList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/7 23:20
 */

/*
* 题目要求：给定两个head，就是两个单链表的头节点，value为0-9，
* 现在要将两个单链表相加，返回新生成的链表的头节点
* 9-3-7  6-3
* 1-0-0-0
*
* 首先可以想到的是先分别将两个链表转换成正数，然后相加，然后再分割成单链表
* 但是这种方式会造成溢出；
* */
public class AddList {
    /*
    * 方法1，利用栈结构解决：两个栈s1和s2，然后同时弹出，相加，
    * 定义一个变量ca记录是否有进位，两个Node指针迭代式形成链表
    * 如果某一次一个栈为空，弹出0就行
    * */
    public static Node addList(Node head1,Node head2){

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        //此时已经全部入栈
        //下面就是定义变量，然后形成新的链表
        //两个Node指针不断迭代循环；
        Node pre = null;
        Node newNode = null;
        int ca = 0;
        int tempSum = 0;
        int n1 = 0;
        int n2 = 0;

        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            tempSum = n1 + n2 + ca;
            pre = newNode;
            newNode = new Node(tempSum % 10);
            newNode.next = pre;
            ca = tempSum / 10;
        }
        //上面的额循环完了之后，还要再判断ca是不是1，因为最后一次相加如果产生进位的话
        //就需要再new一个Node，value为1；
        if (ca == 1){
            pre = newNode;
            newNode = new Node(1);
            newNode.next = pre;
        }

        return newNode;
    }


}
