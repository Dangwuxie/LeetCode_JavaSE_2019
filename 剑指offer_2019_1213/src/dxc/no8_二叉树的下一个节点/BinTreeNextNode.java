package dxc.no8_二叉树的下一个节点;

/**
 * @author dxc
 * @Title: BinTreeNextNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/13 12:42
 */
/*
* 问题：给定一个二叉树节点，求出此节点在中序遍历中的下一个节点
* 节点结构，三个指针，左右、父节点，一个value；
* */

class TriTreeNode{

    public  TriTreeNode parent;
    public  TriTreeNode left;
    public  TriTreeNode right;

    public  Integer value;

    public TriTreeNode(Integer value) {
        this.value = value;
    }
}

public class BinTreeNextNode {
    /*
    * 解题思路：由于是中序遍历，所以有下面几个规律
    * 1、如果一个节点有右子树，那么下一个节点就是它的右子树中最左的节点
    * 2、没有右子树，如果它本身是它父节点的左子树，那么父节点就是下一个节点
    * 3、没有右子树，还是父节点的右子树，那么就需要向上寻找，
    * 找出本身是父节点的左子树的那个节点，它的父节点就是下一个节点
    * */
    public static TriTreeNode getNextNode(TriTreeNode head){
        TriTreeNode nextNode = null;//这个就是保存下一个节点的指针
        //首先判断是不是有右子树
        if (head.right != null){
            TriTreeNode pRigtht = head.right;
            while (pRigtht.left != null){
                pRigtht = pRigtht.left;
            }
            nextNode = pRigtht;
        }else if (head.parent != null){
            //此时说明当前的节点没有右子树
            //那么只剩两种情况了
            TriTreeNode pParent = head.parent;
            TriTreeNode cur = head;
            //判别条件，当cur是pParent的右子树的时候一直循环
            //咱们要找的是cur是pParent的左子树的情况，
            //那么此时pParent就是head的下一个节点
            while (pParent != null && cur == pParent.right){
                cur = pParent;
                pParent = pParent.parent;
            }
            //如果当前节点是二叉树中最右边的节点，那么中序遍历它就是最后一个节点
            //此时while循环出来之后pParent就是指向null；所以此时nextNode也指向的是null；
            nextNode = pParent;
        }




        return nextNode;
    }

}









