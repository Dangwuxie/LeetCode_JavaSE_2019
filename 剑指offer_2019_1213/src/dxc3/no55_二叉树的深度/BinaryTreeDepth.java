package dxc3.no55_二叉树的深度;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: BinaryTreeDepth
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/19 12:15
 */
/*
* 递归求二叉树的深度；
* */
public class BinaryTreeDepth {

    public static int theTreeDepth(BinTreeNode head){

        if (head == null){
            return 0;
        }

        int NLeft = theTreeDepth(head.left);
        int NRight = theTreeDepth(head.right);

        return NLeft > NRight ? NLeft+1 : NRight+1;
    }
}
