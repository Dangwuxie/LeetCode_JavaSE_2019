package dxc.no11_两个单链表生成相加链表;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/7 23:20
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(9);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        n1.next = n2;
        n2.next = n3;

        Node n4 = new Node(6);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        n4.next = n5;
        n5.next = n6;

        PrintLinkedList.printLinkedList(AddList.addList(n1,n4));

    }
}
