package dxc.no23_链表中环的入口节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/31 15:46
 */
public class Test {

    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n6.next = n3;

        System.out.println(EntryOfLoop.findEntryOfLoop(n1).value);

    }
}
