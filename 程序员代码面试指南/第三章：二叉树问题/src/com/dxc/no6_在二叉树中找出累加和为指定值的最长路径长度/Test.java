package com.dxc.no6_在二叉树中找出累加和为指定值的最长路径长度;

import com.dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/3 22:11
 */
public class Test {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);

        Node n5 = new Node(1);
        Node n6 = new Node(4);
        Node n7 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n6.right = n7;


        System.out.println(GetMaxLength.getMaxLength(n1,5));
    }
}
