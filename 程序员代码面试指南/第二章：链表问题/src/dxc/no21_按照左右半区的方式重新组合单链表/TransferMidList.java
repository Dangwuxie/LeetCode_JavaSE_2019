package dxc.no21_按照左右半区的方式重新组合单链表;

import dxc.Node;

/**
 * @author dxc
 * @Title: TransferMidList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/25 21:37
 */

/*
* 题目要求：给定一个链表的头节点，长度为N，前半部分和后半部分的区域以这种方式合并
* 1-2-3-4-5-6 ==>> 1-4-2-5-3-6
* 1-2-3-4-5-6-7 ==>> 1-4-2-5-3-6-7
*
* 奇数偶数都是这样合并;
* */
public class TransferMidList {

    public static Node transferMidList(Node head){
        //首先呢，如果链表为空或者长度为1，直接结束过程；
        if (head == null || head.next == null){
            return head;
        }
        //此时就找出链表的中间节点mid和右半区第一个节点
        //也就是mid.next
        Node mid = head;
        Node cur = head.next;
        while (cur.next != null && cur.next.next != null){
            mid = mid.next;
            cur = cur.next.next;
        }

        Node right = mid.next;//取得右半区的第一个节点

        mid.next = null;//分割成两个链表，然后可以通过一个函数进行合并；

        merge(head,right);

        return head;
    }

    private static void merge(Node left,Node right){
        Node next = null;

        while (left.next != null ){
            //&& right.next != null 不用加的原因
            //不论怎样，总是后半部分的长度大于前半部分的
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        //此时left已经是最后一个节点
        left.next = right;
    }


}
