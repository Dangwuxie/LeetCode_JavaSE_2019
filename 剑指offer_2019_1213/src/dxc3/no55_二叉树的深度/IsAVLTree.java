package dxc3.no55_二叉树的深度;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: IsAVLTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/19 18:30
 */
/*
* 题目要求：判断是不是AVL树；
* 如果某个二叉树任意节点的左右子树的深度相差不超过1，
* 那么它就是一课平衡二叉树，否则就不是；
* */
public class IsAVLTree {
    /*
    * 实现思路，其实可以在遍历到每个节点的时候直接调用前面写好的求深度的函数来判断
    * 不过这样的话会重复遍历某些节点；
    * 所以可以换个思路，从下往上计算，采用后序遍历的方法，左右子节点遍历完后，
    * 就知道当前节点的左右子树的深度，就可以判断深度差；
    * */
    public static boolean isAVLTree(BinTreeNode head){

        if (head == null){
            return false;
        }
        int diff = isAVLTreeCore(head);

        if (diff == -1){
            return false;
        }
        return true;
    }

    private static int isAVLTreeCore(BinTreeNode root){

        if (root == null){
            return 0;
        }

        int left = isAVLTreeCore(root.left);
        int right = isAVLTreeCore(root.right);

        if (left == -1 || right == -1){
            //说明有一个节点的左右子树深度超过1了；
            return -1;
        }

        int diff = left - right;
        if (diff > 1 || diff < -1){
            return -1;
        }

        return left > right ? left+1 : right+1;
    }
}







