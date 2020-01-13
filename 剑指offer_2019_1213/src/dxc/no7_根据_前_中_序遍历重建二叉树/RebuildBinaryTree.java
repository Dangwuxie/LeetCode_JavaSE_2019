package dxc.no7_根据_前_中_序遍历重建二叉树;

import dxc.BinTreeNode;

/**
 * @author dxc
 * @Title: RebuildBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/12 18:33
 */
public class RebuildBinaryTree {

    public static BinTreeNode rebuildBinaryTree(int[] preOrder,int[] inOrder){
        if (preOrder == null || inOrder == null
                || preOrder.length == 0 || inOrder.length == 0){
            return null;
        }
        //先序遍历和中序遍历的每个节点的左右子树节点的数量
        return rebuildCore(preOrder,inOrder,
                0,preOrder.length-1,
                0,inOrder.length-1);

    }

    private static BinTreeNode rebuildCore(int[] preOrder,int[] inOrder,
                                           int preStart,int preEnd,
                                           int inStart,int inEnd){
        //首先，先序遍历的第一个数就是二叉树的头节点
        BinTreeNode headPre = new BinTreeNode(preOrder[preStart]);

        //此时需要判断一下，当前的节点是不是最后一个节点
        if (preStart == preEnd){
            //如果此时先序遍历时的下标相同
            if (inStart == inEnd && preOrder[preStart] == inOrder[inStart]){
                //此时说明两个数组的遍历顺序是相同的，也就是说是同一个二叉树
                return headPre;//此时返回当前的节点就行了
            }else {
                //否则，说明两个数组的遍历的数字是不相同的，不是同一棵二叉树
                try {
                    throw new Exception("不是同一棵二叉树！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        //此时已经得到前序遍历的第一个节点了，下面就是继续往后连接节点，
        //下面找中序遍历中根节点的位置，
        //然后就可以得出当前节点的左子树和右子树有哪些节点了
        int headIn = inStart;//从当前的左子树的第一个节点开始遍历
        while(headIn < inEnd && inOrder[headIn] != headPre.value){
            ++headIn;
        }
        //此时while循环从中出来的时候，headInder刚好就是中序遍历结果中头节点左边的位置；
        //此时如果本轮的遍历过程中遍历结束也没有与前面头节点的值相等的值，就抛出异常

        if (headIn == inEnd && inOrder[headIn] != headPre.value){
            //否则，说明两个数组的遍历的数字是不相同的，不是同一棵二叉树
            try {
                throw new Exception("不是同一棵二叉树！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //此时已经知道中序遍历中头节点的位置为hadIn
        //开始构建当前的二叉树
        //判定条件，当前的headPre左边是否有子树
        int leftLength = headIn - inStart;
        if (leftLength > 0){
            //说明此时左子树还存在元素，继续递归遍历
            //首先，前序遍历的数组起始点就是preStart+1，末尾就是起点加上左子树的长度-1
            //pre+leftLength.
            //inStart,headIn-1就是左子树在中序遍历中的下标范围
            //preStart+1,preStart+leftLength是左子树在前序遍历中的下标范围
            headPre.left = rebuildCore(preOrder,inOrder,
                    preStart+1,preStart+leftLength,
                    inStart,headIn-1);
        }
        //下面判断一下当前的head节点右边有没有子树
        if (leftLength < preEnd - preStart){
            //说明前序遍历中，跟在head节点后面的除了左子树部分外
            //还存在右子树
            headPre.rigth = rebuildCore(preOrder,inOrder,
                    preStart+leftLength+1,preEnd,
                    headIn+1,inEnd);
        }

        return headPre;
    }
}
