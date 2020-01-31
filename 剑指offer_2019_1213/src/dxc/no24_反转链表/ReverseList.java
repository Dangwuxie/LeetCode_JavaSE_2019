package dxc.no24_反转链表;

import dxc.Node;

/**
 * @author dxc
 * @Title: ReverseList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/31 22:08
 */
public class ReverseList {

    public static Node reverseList(Node head){

        if (head == null || head.next == null){
            return head;
        }
        //三个指针迭代式一一反转
        Node pre = null;
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /*
    * 递归实现反转链表
    * */
    public static Node reverseList2(Node head){

        if (head == null || head.next == null){
            return head;
        }
        return reverseListCore(head);
    }

    private static Node reverseListCore(Node head){

        if (head == null || head.next == null){
            //最后一个节点的时候返回当前的这个节点，就是反转后的第一个节点
            return head;
        }
        //newHead就是最后一个节点，一直不变
        Node newHead = reverseListCore(head.next);
        //此时head.next是当前节点的下一个节点，
        // 然后再next一下，指向我自己
        //此时当前的下一个节点已经成功完成反转
        //然后将head本来指向下一个节点的next指针置为null就行了；
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}









