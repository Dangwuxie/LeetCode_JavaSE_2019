package dxc.no20_合并两个有序的单链表;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/25 20:39
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(6);

        Node s1 = new Node(2);
        Node s2 = new Node(3);
        Node s3 = new Node(7);

        n1.next = n2;
        n2.next = n3;

        s1.next = s2;
        s2.next = s3;

        PrintLinkedList.printLinkedList(MergeOrderlyList.mergeOrderlyList(n1,s1));
    }
}
