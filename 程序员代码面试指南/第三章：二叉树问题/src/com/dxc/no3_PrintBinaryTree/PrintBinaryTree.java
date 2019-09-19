package com.dxc.no3_PrintBinaryTree;

import com.dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: PrintBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/19 22:42
 */

/*
* 思路：打印二叉树的结构，样子，有很多方法，下面是其中一种思路：
* 比如一个二叉树这样：
*       1
*     2   3
*   4    5  6
*     7
* 打印可以这样打印：
*         v6v
*     v3v
*        ^5^
* h1h
*     ^2^
*            v7v
*        ^4^
*   可以看出，打印出来的结构就是将原来的二叉树逆时针旋转90°
*   打印出来，分析一下：
*   每个右孩子都是vv夹着数据，左孩子都是^夹着^，因为每个叶子节点的数据
*   的位数不确定，但是Java中最长的就是-2147483648，11位，加上数据两边的符号，13位
*   然后为了打印出来可以对齐，两边再加上两个空格，然后一共是17位，
*   如果是v7v,这样，前面7空格，后面补7空格
*   如果是v77v,前面6空格，后面7空格，用大小相隔最近的两个数量的空格补充，
*   前面是较小的数量，后面较大的数量
*
*   下面说一下具体的实现：先右子树再根节点再左子树，递归遍历；
*   是父节点的右子树打印vv，父节点的左子树打印^^;
*
* */

public class PrintBinaryTree {

    public static void printBinaryTree(Node head){
        System.out.println("二叉树的宏观遍历");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    public static void printInOrder(Node head,int height,String to,int len){
        if (head==null)return;
        printInOrder(head.right,height+1,"v",len);//右子树递归打印vv
        //中间打印它们的父节点head
        String val = to+head.value+to;
        int lenTotal = val.length();
        int lenLeft = (len-lenTotal)/2;//左边空格的数量
        int lenRight = len-lenLeft-lenTotal;//右边空格数量
        val = getSpace(lenLeft)+val+getSpace(lenRight);

        System.out.println(getSpace(height*len)+val);

        printInOrder(head.left,height+1,"^",len);//打印左子树^^夹着

    }

    public static String getSpace(int nums){
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i=0;i<nums;i++){
            buf.append(space);
        }
        return buf.toString();
    }
}
