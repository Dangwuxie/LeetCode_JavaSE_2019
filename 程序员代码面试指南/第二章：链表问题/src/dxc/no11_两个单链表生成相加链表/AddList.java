package dxc.no11_两个单链表生成相加链表;

import dxc.Node;
import dxc.ReverseList;

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

    /*
    * 方法2，反转两个单链表，然后从头节点开始相加，
    * 同时需要考虑进位，最后重新恢复原来的两个单链表
    * 返回相加之后的和形成的新的链表
    *
    * */
    public static Node addList2(Node head1,Node head2){
        head1 = ReverseList.reverseList(head1);
        head2 = ReverseList.reverseList(head2);

        Node c1 = head1;
        Node c2 = head2;

        int tempSum = 0;
        int n1 = 0;
        int n2 = 0;
        int ca = 0;

        Node pre = null;
        Node newNode = null;

        while (c1 != null || c2 != null){
            n1 = c1 == null ? 0 : c1.value;
            n2 = c2 == null ? 0 : c2.value;
            tempSum = n1 + n2 + ca;
            pre = newNode;
            newNode = new Node(tempSum % 10);
            newNode.next = pre;
            ca = tempSum / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }

        if (ca == 1){
            pre = newNode;
            newNode = new Node(ca);
            newNode.next = pre;
        }
        //复原
        ReverseList.reverseList(head1);
        ReverseList.reverseList(head2);

        return newNode;
    }


}
