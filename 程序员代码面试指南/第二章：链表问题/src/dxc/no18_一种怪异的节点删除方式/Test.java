package dxc.no18_一种怪异的节点删除方式;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/24 22:56
 */
public class Test {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        RemoveNode.removeNode(n3);
        PrintLinkedList.printLinkedList(n1);
    }
}
