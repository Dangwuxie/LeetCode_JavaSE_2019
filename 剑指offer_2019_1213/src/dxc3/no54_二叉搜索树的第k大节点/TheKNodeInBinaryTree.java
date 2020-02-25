package dxc3.no54_二叉搜索树的第k大节点;


import dxc.BinTreeNode;

import java.util.Stack;

/**
 * @author dxc
 * @Title: TheKNodeInBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/18 17:50
 */
/*
* 题目要求，给定一个二叉搜索树，找出其中第k大的节点；
* */
/*
* 思路，二叉搜索树的中序遍历就是按照从小到大的顺序遍历
* 很容易找到第k大的节点；由于Java语法的限制，可以用栈按照顺序存储一遍
* 最后倒叙求出所要求的第k大的节点；
* */
public class TheKNodeInBinaryTree {

    public static BinTreeNode findTheKNode(BinTreeNode head, int k){

        if (head == null || k == 0){
            return null;
        }
        Stack<BinTreeNode> count = new Stack<>();
        KthNode(head,k,count);
        int lastKTh = count.size() - k;
        while (lastKTh != 0){
            count.pop();
            lastKTh--;
        }

        return count.pop();
    }


    private static void KthNode(BinTreeNode head,int k,Stack<BinTreeNode> count){

        if (head == null){
            return;
        }
        KthNode(head.left,k,count);
        count.push(head);
        KthNode(head.right,k,count);

    }

    /*private static void KthNodeC++(BinTreeNode head,int k){

        //下面的代码c++适合
        *//*BinTreeNode target = null;

        if (head.left != null){
            target = KthNode(head.left,k);
        }

        if (target == null){
            if (k == 1){
                target = head;
            }
            k--;
        }
        if (target == null && head.right != null){
            target = KthNode(head.right,k);
        }

        return target;
    }*/

}
