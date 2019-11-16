package dxc.no7_判断链表是否为回文结构;

import dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/16 17:08
 */
public class Test {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(IsHuiWenList.isHuiWenList3(n1));

    }
}
