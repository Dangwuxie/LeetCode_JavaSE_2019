package dxc.no26_树的子结构;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/1 17:34
 */
public class Test {

    public static void main(String[] args) {

        BinTreeNode a1 = new BinTreeNode(8);
        BinTreeNode a2 = new BinTreeNode(8);
        BinTreeNode a3 = new BinTreeNode(7);

        BinTreeNode a4 = new BinTreeNode(9);
        BinTreeNode a5 = new BinTreeNode(2);
        BinTreeNode a6 = new BinTreeNode(4);
        BinTreeNode a7 = new BinTreeNode(7);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a5.left = a6;
        a5.right = a7;

        BinTreeNode b1 = new BinTreeNode(8);
        BinTreeNode b2 = new BinTreeNode(9);
        BinTreeNode b3 = new BinTreeNode(2);
        b1.left = b2;
        b1.right = b3;

        System.out.println(IsTree1HasTree2.isTree1HasTree2(a1,b1));
    }
}
