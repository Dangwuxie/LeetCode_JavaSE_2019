package com.dxc.no4_二叉树的序列化和反序列化;

import com.dxc.Node;
import com.dxc.no3_PrintBinaryTree.PrintBinaryTree;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/7 22:48
 */

public class Test {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.left = node2;

        /*String str = SerialByPre.serialByPre(node1);
        System.out.println(str);
        PrintBinaryTree.printBinaryTree(SerialByPre.reconByPreSerial(str));
        */

        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        h1.left = h2;
        h1.right = h3;
        h2.left = h4;
        h3.right = h5;
        //输出序列化后的字符串
        System.out.println(SerialByLevel.serialByLevel(h1));




    }
}
