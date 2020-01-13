package dxc.no7_根据_前_中_序遍历重建二叉树;

import dxc.PrintBinaryTree;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/12 18:31
 */
public class Test {

    public static void main(String[] args) {

        int[] preArr = new int[]{1,2,4,7,3,5,6,8};
        int[] inArr = new int[]{4,7,2,1,5,3,8,6};

        PrintBinaryTree.printBinaryTree(RebuildBinaryTree.rebuildBinaryTree(preArr,inArr));
    }
}
