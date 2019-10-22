package dxc.no3_删除链表的中间节点和ab处的节点;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/20 23:49
 */

/*
* 一级：
* 删除链表的中间节点和a/b处的节点
*
* */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        /*RemoveMidNode.removeMidNode(n1);
        PrintLinkedList.printLinkedList(n1);*/

        RemoveMidNode.removeABNode(n1,2,5);
        PrintLinkedList.printLinkedList(n1);
    }
}
