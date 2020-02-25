package dxc3.no55_二叉树的深度;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/19 12:14
 */
public class Test {

    public static void main(String[] args) {

        BinTreeNode h1 = new BinTreeNode(1);
        BinTreeNode h2 = new BinTreeNode(2);
        BinTreeNode h3 = new BinTreeNode(3);
        BinTreeNode h4 = new BinTreeNode(4);

        BinTreeNode h5 = new BinTreeNode(5);
        BinTreeNode h6 = new BinTreeNode(6);
        BinTreeNode h7 = new BinTreeNode(7);

        h1.left = h2;
        h1.right = h3;

        h2.left = h4;
        h2.right = h5;

        h4.left = h6;
        h6.left = h7;

        /*System.out.println(BinaryTreeDepth.theTreeDepth(h1));*/

        System.out.println(IsAVLTree.isAVLTree(h1));

    }
}
