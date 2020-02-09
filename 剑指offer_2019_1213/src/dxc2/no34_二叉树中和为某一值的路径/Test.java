package dxc2.no34_二叉树中和为某一值的路径;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/8 11:24
 */
public class Test {

    public static void main(String[] args) {

        BinTreeNode h1 = new BinTreeNode(10);
        BinTreeNode h2 = new BinTreeNode(5);
        BinTreeNode h3 = new BinTreeNode(12);
        BinTreeNode h4 = new BinTreeNode(4);

        BinTreeNode h5 = new BinTreeNode(7);

        h1.left = h2;
        h1.right = h3;

        h2.left = h4;
        h2.right = h5;

        FindPathInTree.findPath(h1,22);
    }
}
