package dxc.no13_单链表的每k个节点之间的逆序;

import dxc.Node;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: ReverseKNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/8 20:56
 */
/*
* 题目要求：给定一个head头节点，一个整形k，要求每k个节点反转一次链表
* 如果最后几个节点不足k，就不反转；
* */
public class ReverseKNode {
    /*
    * 思路1：利用栈结构，o(n)的时间复杂度和空间复杂度
    * 实现方法，利用栈结构，每入栈k个节点，就弹出并且反转这k个节点
    * 注意细节，注意第一次k个节点的反转，用一个newNode保存下来，
    * 就是最后要返回的总链表的头节点，其次，每次反转k个节点，都要保存这k个节点的下一个节点；
    *
    * */
    public static Node reverseKNode1(Node head,int k){
        if (k < 2){
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node newNode = head;//最终返回的头节点
        Node cur = head;
        Node pre = null;
        Node next = null;

        while (cur != null){
            //先把next保存下来，如果发生反转的话，后面要用到;
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k){
                //调用反转链表的函数获得反转后的头节点pre
                //pre每次都是指向k个节点的前一个节点
                pre = reverseK(stack,pre,next);
                //第一次k个节点反转后确定头节点
                newNode = newNode == head ? cur : newNode;
            }
            cur = next;
        }

        return newNode;
    }

    private static Node reverseK(Stack<Node> stack,Node left,Node right){
        Node cur = stack.pop();
        if (left != null){
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        next.next = right;
        //反转k个节点的最后一个节点
        return cur;
    }


    /*
    * 思路2：暴力反转，利用仅有的几个变量，每次到k个节点的时候进行反转
    * 注意细节：第一组的头节点要用一个newHead指针记录，每次反转一组，
    * 需要记录本组链表的前一个节点left和后一个节点right，
    * 以及本组的开始节点start和结束节点end，
    * */
    public static Node reverseKNode2(Node head,int k){

        if (k < 2){
            return null;
        }

        Node start = head;
        Node end = null;
        Node left = null;
        Node right = null;
        int count = 0;//计数
        Node cur = head;
        Node newNode = head;

        while (cur != null){
            //保存下一组的第一个节点
            right = cur.next;
            count++;
            if (count == k){
                end = cur;
                reverseK2(left,start,end,right);
                count = 0;
                newNode = newNode == head ? end : newNode;
                //保存下一组的前一个节点；
                left = start;
                //下一组的第一个节点
                start = right;
            }
            //从下一组第一个节点开始遍历
            cur = right;
        }

        return newNode;
    }

    private static void reverseK2(Node left,Node start,Node end,Node right){
        //保存本组的第一个节点，就是反转之后的最后一个节点
        Node pre = null;
        Node next = null;
        //从本组的链表开始反转链表
        Node cur = start;

        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //此时本组反转之后的最后一个节点就是start
        //反转之后的第一个节点就是end
        //left-1-2-3-4-right
        //left-4-3-2-1-right
        if (left != null){
            left.next = end;
        }

        start.next = right;
    }
}





