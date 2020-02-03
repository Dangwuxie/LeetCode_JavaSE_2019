package dxc.no26_树的子结构;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: IsTree1HasTree2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/1 17:34
 */
/*
* 题目要求，输入两棵二叉树A和B，判断B是不是A的子结构；
* */
public class IsTree1HasTree2 {
    /*
    * 实现思路：二叉树的遍历，递归实现；如果当前的两个节点相等，就调用另外一个函数判断；
    * 否则就遍历n1的左右子树继续判断是否存在与N2树根相同的节点
    * 如果存在，那么就调用isContain；
    * */
    public static boolean isTree1HasTree2(BinTreeNode n1,BinTreeNode n2){

        boolean result = false;

        if (n1 != null && n2 != null){

            if (n1.value == n2.value){
                result = isContainB(n1,n2);
            }
            if (!result){
                result = isTree1HasTree2(n1.left,n2);
            }
            if (!result){
                result = isTree1HasTree2(n1.right,n2);
            }
        }

        return result;
    }

    private static boolean isContainB(BinTreeNode n1,BinTreeNode n2){

        if (n2 == null){
            return true;
        }

        if (n1 == null){
            return false;
        }
        //此时n1、n2都没有到头
        //继续判断

        if (n1.value != n2.value){
            return false;
        }
        //此时说明当前的两个节点还是相等,继续递归判断
        return isContainB(n1.left,n2.left) && isContainB(n1.right,n2.right);
    }
}
