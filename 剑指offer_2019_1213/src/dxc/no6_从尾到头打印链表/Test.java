package dxc.no6_从尾到头打印链表;

import dxc.Node;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/23 20:54
 */
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

        ListOfInversion.ListOfInversion1(n1);
        System.out.println();
        ListOfInversion.ListOfInversion2(n5);
        System.out.println();
        ListOfInversion.ListOfInversion3(n5);

    }

    /*
    *
        5-4-3-2-1-
        1-2-3-4-5-
        1-2-3-4-5-
    * */
}
