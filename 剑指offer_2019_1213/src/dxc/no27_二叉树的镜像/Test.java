package dxc.no27_二叉树的镜像;

import dxc.BinTreeNode;
import dxc.PrintBinaryTree;

import java.util.Arrays;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 14:39
 */
public class Test {

    public static void main(String[] args) {

        BinTreeNode n1 = new BinTreeNode(8);
        BinTreeNode n2 = new BinTreeNode(6);
        BinTreeNode n3 = new BinTreeNode(10);
        BinTreeNode n4 = new BinTreeNode(5);

        BinTreeNode n5 = new BinTreeNode(7);
        BinTreeNode n6 = new BinTreeNode(9);
        BinTreeNode n7 = new BinTreeNode(11);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        //MirrorBinaryTree.getMirrorBinaryTree(n1);
        PrintBinaryTree.printPreBinaryTree(n1);

    }
}
