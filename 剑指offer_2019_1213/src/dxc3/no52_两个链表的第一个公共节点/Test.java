package dxc3.no52_两个链表的第一个公共节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/12 13:48
 */
public class Test {

    public static void main(String[] args) {

        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);

        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);

        h6.next = h7;

        h1.next = h2;
        h2.next = h3;
        h3.next = h6;

        h4.next = h5;
        h5.next = h6;

        System.out.println(FirstCommonNode.findFirstCommonNode(h1,h4).value);

    }
}






