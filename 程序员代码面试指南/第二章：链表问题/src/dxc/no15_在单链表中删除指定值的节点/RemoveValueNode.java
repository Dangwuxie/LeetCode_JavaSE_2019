package dxc.no15_在单链表中删除指定值的节点;

import dxc.Node;

import java.util.Stack;

/**
 * @author dxc
 * @Title: RemoveValueNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/11 22:00
 */
/*
* 问题：给定一个head，整数num，要求删除链表中value等于num的节点
*
* */
public class RemoveValueNode {
    /*
    * 方法1：利用栈结构，从head开始入栈
    * 碰到值等于num的节点跳过
    * 最后出栈重新连接成链表
    * */
    public static Node removeValueNode1(Node head, int num){
        if (head == null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            if (cur.value != num){
                stack.push(cur);
            }
            cur = cur.next;
        }
        //重新出栈连接新链表
        while (!stack.isEmpty()){
            stack.peek().next = cur;
            cur = stack.pop();
        }
        return cur;
    }

    /*
    * 方法2：直接调整，不利用任何结构
    * 首先从head开始遍历节点，找到第一个value不等于num的节点作为新链表的头节点
    * 然后利用两个指针pre和cur往后遍历，如果不相等，就让pre=cur，
    * 相等的话就pre=cur.next；pre始终指向最近的一个没有被删除的节点
    * */
    public static Node removeValueNode2(Node head,int num){
        while (head != null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }
        //从上面的while循环出来后head必定指向第一个不等于num的节点
        Node pre = head;
        Node cur = head;
        while (cur != null){
            if (cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
