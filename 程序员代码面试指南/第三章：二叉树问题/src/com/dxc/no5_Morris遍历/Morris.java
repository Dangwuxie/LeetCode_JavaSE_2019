package com.dxc.n05_Morris遍历;

import com.dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: Morris
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/8 21:16
 */

/*
* 规则：从头节点head开始访问，最终本质就是让最下层指向null的节点指向上层的某个节点
*       从而完成二叉树的从下层到上层的移动与遍历；
*
*   如果头节点有左子树，访问左子树最右边的节点，记为mostright，
*   1、如果mostright的right节点为null，令其指向head，就是mostright.right=head;
*   2、完了之后，head指针左移，head=head.left,如果此时head存在左子树，继续1的操作
*   如果此时节点没有左子树，那么head向右移动，head=head.right；
*   再次判断左子树和mostright，继续1的操作
*
*   如果当前的head的位置指向head，那么令mostright=null，然后head右移；
*
*   此方法遍历二叉树时间复杂度为O(n),额外空间复杂度为O(1);
*
*   总结一下，基本上head指针走过两次的节点都是第一次跑到左子树上去，第二次要么跑到右子树，要么返回上级
*   走过一次的节点，要么返回上级，要么回到该节点指向的上层节点；
*
*   思路：首先从头节点开始遍历，每次都去找左子树最右边的节点，将此节点的right指向本节点
*   然后左移本节点，依次类推；
*   如果发现某个节点没有左子树，但是right指针指向的是本节点，
*   那么变成null，然后当前指针右移或者返回上一层
*
* */
public class Morris {

    public static void morris(Node head){
        if(head == null){
            return;
        }

        Node cur = head;

        while (cur != null){
            //每次循环都需要找到左子树的最右节点
            //如果找不到，那么返回上一层或者向右移动(就是mostright指向的上层节点)
            Node mostRight = cur.left;
            if (cur.left != null){
                //找最右边的节点
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //此时mostRight已经走到cur的左子树的最右边
                //此时不知道是第几次经过此节点，需要判断
                if (mostRight == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    //注意，此处使用continue的原因
                    //每次while循环cur都会移动
                    //如果有左树，就找到mostright，指向cur
                    //然后跳出本次循环
                    continue;
                }else {
                    //否则就是有指向null
                    mostRight.right = null;
                }

            }
            //此时发现没有左子树，那么就需要右移cur
            //或者将指向cur的mostright变成null后，右移
            cur = cur.right;

        }
    }

    public static void morrisPreOrder(Node head){
        if(head == null){
            return;
        }

        Node cur = head;

        while (cur != null){

            Node mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    //先序遍历时到达两次的节点第一次需要输出
                    System.out.print(cur.value+" ");
                    //cur如果要进行左移的话就跳出当前循环执行下一次循环
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else {
                //此处加个else，就是为了如果没有左子树的话，此时就需要输出当前cur的值
                //下一步就是右移；先序遍历二叉树是"上左右"的顺序
                System.out.print(cur.value+" ");
            }
            cur = cur.right;
        }
    }

    public static void morrisInOrder(Node head){
        if(head == null){
            return;
        }
        Node cur = head;

        while (cur != null){

            Node mostRight = cur.left;
            if (cur.left != null){
                //找最右边的节点
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    //第一次到达节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    //这个条件里就是第二次走到该节点了
                    //指向null之后，后面的语句会输出当前cur的值
                    mostRight.right = null;
                }
            }
            //此处就是，只到达一次的节点和第二次到达的节点的输出
            System.out.print(cur.value+" ");
            cur = cur.right;

        }
    }
}
