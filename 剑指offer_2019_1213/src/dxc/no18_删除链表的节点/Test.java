package dxc.no18_删除链表的节点;

import dxc.Node;
import dxc.PrintList;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/23 22:43
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(4);
        Node n4 = new Node(4);

        Node n5 = new Node(5);
        Node n6 = new Node(5);
        Node n7 = new Node(8);
        Node n8 = new Node(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        /*PrintList.printList(RemoveListNode.removeListNode(n1,n1));*/

        PrintList.printList(RemoveRepeatNodeList.removeRepeatNodeList(n1));
    }
}
