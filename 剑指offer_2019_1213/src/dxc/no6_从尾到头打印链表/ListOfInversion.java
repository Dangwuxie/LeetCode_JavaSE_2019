package dxc.no6_从尾到头打印链表;

import dxc.Node;

import java.util.Stack;

/**
 * @author dxc
 * @Title: ListOfInversion
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/23 20:54
 */
/*
* 给定一个链表的头节点，要求将链表从尾到头输出；
* */
public class ListOfInversion {

    /*
    * 1、第一种方法：改变链表的结构，反转链表，然后从头输出
    * */
    public static void ListOfInversion1(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        //此时pre已经到了原来的链表的最后一个节点，就是反转之后的链表的第一个节点
        while (pre != null){
            System.out.print(pre.value+"-");
            pre = pre.next;
        }
    }

    /*
    * 2、第二种方法：可以利用栈结构，从head开始入栈，最后依次出栈
    * */
    public static void ListOfInversion2(Node head){
        Stack<Node> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().value+"-");
        }
    }

    /*
    * 3、第三种方法：既然可以利用栈结构来实现，那么就可以使用递归来实现
    * */
    public static void ListOfInversion3(Node head){
        if (head.next == null){
            System.out.print(head.value+"-");
        }else {
            ListOfInversion3(head.next);
            System.out.print(head.value+"-");
        }
    }

}
