package dxc.no28_对称的二叉树;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 18:03
 */
public class Test {

    public static void main(String[] args) {

        BinTreeNode h1 = new BinTreeNode(8);
        BinTreeNode h2 = new BinTreeNode(6);
        BinTreeNode h3 = new BinTreeNode(9);
        BinTreeNode h4 = new BinTreeNode(5);

        BinTreeNode h5 = new BinTreeNode(7);
        BinTreeNode h6 = new BinTreeNode(7);
        BinTreeNode h7 = new BinTreeNode(5);

        h1.left =h2;
        h1.right = h3;

        h2.left = h4;
        h2.right = h5;

        h3.left = h6;
        h3.right = h7;

        System.out.println(SymmetricalTree.isSymmetricalTree(h1));

    }
}
