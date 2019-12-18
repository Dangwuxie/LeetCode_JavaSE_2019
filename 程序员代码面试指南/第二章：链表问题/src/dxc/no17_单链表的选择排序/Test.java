package dxc.no17_单链表的选择排序;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/18 23:11
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(8);

        Node n6 = new Node(9);
        Node n7 = new Node(11);
        Node n8 = new Node(4);
        Node n9 = new Node(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        PrintLinkedList.printLinkedList(ListSelectionSort.listSelectionSort(n1));
    }
}
