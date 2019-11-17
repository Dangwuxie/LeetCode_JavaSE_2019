package dxc.no9_将单向链表按照某值划分左小中相等右边大的形式;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/17 11:39
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(3);

        Node n6 = new Node(5);
        Node n7 = new Node(9);
        Node n8 = new Node(8);
        Node n9 = new Node(4);
        Node n10 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;


        /*PrintLinkedList.printLinkedList(
                ListPartition.listPartition1(n1,5));
        System.out.println();*/
        PrintLinkedList.printLinkedList(
                ListPartition.listPartition2(n1,5));
    }
}
