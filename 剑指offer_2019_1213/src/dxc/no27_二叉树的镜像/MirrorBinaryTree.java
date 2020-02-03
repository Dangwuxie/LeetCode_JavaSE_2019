package dxc.no27_二叉树的镜像;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: MirrorBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 16:01
 */
/*
* 问题：输入一个二叉树，该函数输出它的镜像；
* */
public class MirrorBinaryTree {

    /*
    * 思路：前序遍历二叉树，有子节点的就互换子节点；
    * 就是说除了叶子节点外都要进行此操作；
    * */
    public static void getMirrorBinaryTree(BinTreeNode head){

        if (head == null || (head.left == null && head.right == null)){
            return;
        }

        BinTreeNode tempNode = head.left;
        head.left = head.right;
        head.right = tempNode;

        getMirrorBinaryTree(head.left);
        getMirrorBinaryTree(head.right);

    }
}












