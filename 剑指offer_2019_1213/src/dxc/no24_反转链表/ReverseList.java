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
}





