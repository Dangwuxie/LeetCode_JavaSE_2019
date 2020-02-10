package dxc2.no36_二叉搜索树与双向链表;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: ConvertTreeNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/9 16:03
 */
/*
* 题目要求：将一颗二叉搜索树转换成为一个排序的双向链表。
* 要求不能创建新节点(可以新建引用)，只能调整树种节点指针的指向；
* 最后返回双向链表的头节点
* */
public class ConvertTreeNode {
    /*
    * 思路，我们可以创建一个指针lastNode一直指向排好序链表部分的最后一个节点
    * 二叉搜索树只有中序遍历之后的结果是排好序的
    * 利用递归的方式，如果当前节点的左子树不为空，就递归左部分
    * 左边递归到最后一个节点，会回溯这个节点，就是lastNode，
    *
    * 回溯到上一个函数里，lastNode.right就可以指向这个节点原本的父节点
    * 然后在递归右子树，更新lastNode节点，如果当前节点的右子树是叶子节点
    * 那么此时lastNode就更新为这个叶子节点；
    * */
    public static BinTreeNode convertTreeNode(BinTreeNode head){

        if (head == null){
            return null;
        }

        BinTreeNode lastNodeInList = null;

        BinTreeNode res = convertCore(head,lastNodeInList);

        while (res.left != null){
            res = res.left;
        }

        return res;
    }

    private static BinTreeNode convertCore(BinTreeNode head,BinTreeNode lastNode){

        BinTreeNode curNode = head;

        if (curNode.left != null){
            lastNode = convertCore(curNode.left,lastNode);
        }
        //此时当前节点的右子树以及递归转换完成
        curNode.left = lastNode;

        if (lastNode != null){
            lastNode.right = curNode;
        }

        lastNode = curNode;

        if (curNode.right != null){
            lastNode = convertCore(curNode.right,lastNode);
        }

        return lastNode;
    }
}











