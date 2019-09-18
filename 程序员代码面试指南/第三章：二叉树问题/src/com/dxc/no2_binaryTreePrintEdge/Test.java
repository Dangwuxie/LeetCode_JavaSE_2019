package com.dxc.no2_binaryTreePrintEdge;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/18 20:14
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
        Node h8 = new Node(8);
        Node h9 = new Node(9);
        Node h10 = new Node(10);
        Node h11 = new Node(11);
        Node h12 = new Node(12);
        Node h13 = new Node(13);
        Node h14 = new Node(14);
        Node h15 = new Node(15);
        Node h16 = new Node(16);

        h1.left=h2;
        h1.right=h3;
        h2.right=h4;
        h4.left=h7;
        h4.right=h8;
        h8.right=h11;
        h11.left=h13;
        h11.right=h14;

        h3.left=h5;
        h3.right=h6;
        h5.left=h9;
        h5.right=h10;
        h9.left=h12;
        h12.left=h15;
        h12.right=h16;

        PrintEdge1.printEdge1(h1);

    }
}
