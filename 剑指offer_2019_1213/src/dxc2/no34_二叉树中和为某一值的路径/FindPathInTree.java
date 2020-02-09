package dxc2.no34_二叉树中和为某一值的路径;

import dxc.BinTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxc
 * @Title: FindPathInTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/8 10:34
 */
/*
* 题目要求，输入二叉树的head和一个k，找出二叉树中路径节点之和为k的路径并输出
* 找出所有路径；
* !!!!!!!注意：二叉树的路径是从跟节点开始一直到叶子节点所经过的节点形成一条路径；
* */
public class FindPathInTree {

    public static void findPath(BinTreeNode head,int k){

        if (head == null){
            return;
        }

        int currentK = 0;
        List<BinTreeNode> list = new ArrayList<>();

        findPathCore(head,currentK,k,list);

    }

    private static void findPathCore(BinTreeNode head,int currentK,int k,List<BinTreeNode> list){

        currentK += head.value;
        list.add(head);
        //判断当前的节点是不是叶子叶子节点
        boolean isLast = head.left == null && head.right == null;
        if (currentK == k && isLast){
            //说明此时是叶子节点
            //输出这条路径
            for (BinTreeNode tmp : list){
                System.out.print(tmp.value+"-");
            }
            System.out.print("当前路径符合！");
            System.out.println();
        }else if (isLast && currentK != k){
            for (BinTreeNode tmp : list){
                System.out.print(tmp.value+"-");
            }
            System.out.print("当前路径不符合！");
            System.out.println();
        }
        //如果不是叶子节点，就继续遍历
        if (head.left != null){
            findPathCore(head.left,currentK,k,list);
        }
        if (head.right != null){
            findPathCore(head.right,currentK,k,list);
        }

        list.remove(head);
    }
}

/*
*
*   10-5-4-当前路径不符合！
    10-5-7-当前路径符合！
    10-12-当前路径符合！
* */



