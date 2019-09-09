package com.dxc.no1_binarytreeTraverseRecur;

/**
 * @author 灵魂编程者
 * @Title: binaryTreeTraverseRecur
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/9 9:38
 */
public class binaryTreeTraverseRecur {

    /*先序*/
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }
    /*前序*/
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value);
        inOrderRecur(head.right);
    }

    /*后序*/
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value);
    }
}
