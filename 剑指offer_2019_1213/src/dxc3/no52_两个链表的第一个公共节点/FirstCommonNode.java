package dxc3.no52_两个链表的第一个公共节点;

import dxc.Node;

import java.util.Stack;

/**
 * @author dxc
 * @Title: FirstCommonNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/13 11:51
 */
/*
* 题目要求：找出两个链表的第一个公共节点；
* */
public class FirstCommonNode {
    /*
    * 思路：暴力查找法就是在第一条链表每遍历一个节点，就在另外一条链表上
    * 查找是否有相同的，这样的话时间复杂度就成了O(M*N)了；
    * 可以反过来思考，第一个公共节点之后就是同一条链表了，
    * 那么这个节点反过来就是同一条链表的最后一个节点，
    * 可以利用辅助两个栈，压入，然后一一弹出找最后一个相同的节点
    * 此时就是O(M+N)的时间复杂度；
    *
    * 还有一种不需要辅助栈的O(M+N)的时间复杂度的求解方式，
    * 先分别求出两条链表的长度，长的链表比短的链表短几个节点
    * 就在同时遍历的时候让长链表的指针先走几步，然后两边的
    * 指针同时出发，指向同一个节点的时候就是第一个公共节点
    * */
    public static Node findFirstCommonNode(Node h1,Node h2){

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        Node cur1 = h1;
        Node cur2 = h2;

        while (cur1 != null){
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        Node pre = null;//保存最后一个相等的节点，就是第一个相交的节点
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek().value == stack2.peek().value){
                pre = stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return pre;
    }

}












