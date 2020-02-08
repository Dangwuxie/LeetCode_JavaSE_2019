package dxc2.no33_二叉搜索树的后序遍历序列;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: IsLastOrderOfBST
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/7 20:46
 */
/*
* 给定一个整数数组，判断该数组是否为某一搜索二叉树的后序遍历
* 比如：5 7 6 9 11 10 8,返回true
* 7 4 6 5,返回false
* */
public class IsLastOrderOfBST {

    public static boolean isLastOrderOfBST(int[] arrs,int left,int right){

        if (arrs == null){
            return false;
        }

        int root = right - 1;
        int i = left;
        //先找左子树
        for (;i < right-1; i++){
            if (arrs[i] > arrs[root]){
                break;
            }
        }
        //保存右子树的起点
        int j = i;
        //剩下的到最后一个之前应该都是右子树的，
        //检查一下是否存在大于根节点的值
        for (;j < right-1; j++){
            if (arrs[j] < arrs[root]){
                return false;
            }
        }
        //下面递归判断左右子树是不是BST
        boolean leftTree = true;
        if (i > left){
            //左子树部分所有节点
            leftTree = isLastOrderOfBST(arrs,left,i);//i临界值，是右子树的起点
        }

        boolean rightTree = true;
        if (i < right - 1){
            //注意临界值。right-1，出去root节点的右子树部分
            rightTree = isLastOrderOfBST(arrs,i,right - 1);
        }

        return leftTree && rightTree;
    }
}
