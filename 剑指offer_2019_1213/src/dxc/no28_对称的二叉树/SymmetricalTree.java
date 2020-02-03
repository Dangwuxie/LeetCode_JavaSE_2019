package dxc.no28_对称的二叉树;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: SymmetricalTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 19:07
 */
/*
* 题目要求：判断给定的一颗二叉树是不是对称的；
*
* */
public class SymmetricalTree {


    public static boolean isSymmetricalTree(BinTreeNode head){

        return core(head,head);

    }

    private static boolean core(BinTreeNode h1,BinTreeNode h2){

        if (h1 == null && h2 == null){
            return true;
        }

        if (h1 == null || h2 == null){
            return false;
        }

        if (h1.value != h2.value){
            return false;
        }
        //对称形式的递归遍历
        return core(h1.left,h2.right) && core(h1.right,h2.left);

    }
}
