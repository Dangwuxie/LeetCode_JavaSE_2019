package dxc2.no32_从上到下打印二叉树的三种形式;

import dxc.BinTreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author dxc
 * @Title: PrintBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/7 16:40
 */
/*
* 从上到下打印二叉树
* 第一种形式：层序遍历，每一层都是从左到右
* 第二种形式：依旧是层序，但是需要按照一层一层的输出方式来输出
* 第三种形式：“之”字型打印，同第二种一样，一层一层输出
* */
public class PrintBinaryTree {
    /*
    * 第一种形式，利用队列这个结构实现，每访问到一个节点
    * 就需要在队列后面加上它能访问到的左右子节点
    * 一直出队列，就可以实现；
    * */
    public static void printTopToButton(BinTreeNode head){

        if (head == null){
            try {
                throw new Exception("输出为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Deque<BinTreeNode> deque = new LinkedList<BinTreeNode>();
        deque.add(head);

        while (!deque.isEmpty()){
            BinTreeNode temp =  deque.poll();
            System.out.print(temp.value+"-");

            if (temp.left != null){
                deque.add(temp.left);
            }
            if (temp.right != null){
                deque.add(temp.right);
            }
        }
    }

    /*
    * 第二种层序遍历，每一层占用一行
    * 从左到右输出，
    * 解题思路：设定两个变量，一个表示当前层要打印的节点数，
    * 另一个不断记录下一层要打印的节点数，两个变量的值不断的交替
    * */
    public static void printTopToButton2(BinTreeNode head){

        if (head == null){
            try {
                throw new Exception("输出为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Queue<BinTreeNode> queue = new LinkedList<BinTreeNode>();
        int nextLevel = 0;
        int printLevel = 1;
        queue.add(head);

        while (!queue.isEmpty()){

            BinTreeNode temp = queue.poll();
            System.out.print(temp.value+"  ");

            if (temp.left != null){
                queue.add(temp.left);
                nextLevel++;
            }

            if (temp.right != null){
                queue.add(temp.right);
                nextLevel++;
            }
            --printLevel;
            if (printLevel == 0){
                //说明当前whihle循环输出的是当前层的最后一个节点了，需要换行
                System.out.println();
                printLevel = nextLevel;
                nextLevel = 0;
            }
        }

    }

    /*
    * ”之“字型遍历二叉树，思路，利用两个栈结构
    * 可以看出奇数行都是从左边开始，偶数行从右边开始输出，
    * 可以利用两个栈，遍历当前层的时候往另外一个栈中添加下一层的节点
    * 由于栈是先进后出，所以奇数行先添加右子节点再加左子节点
    * 偶数行先添加左子节点再右子节点；
    * */
    public static void printTopToButton3(BinTreeNode head){

        if (head == null){
            try {
                throw new Exception("传入有错！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Stack<BinTreeNode> stack1 = new Stack<>();//奇数
        Stack<BinTreeNode> stack2 = new Stack<>();//偶数
        stack1.push(head);
        int current = 1;
        BinTreeNode temp = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            if (current == 1){
                temp = stack1.pop();
                System.out.print(temp.value+" ");
                //当前为奇数行，给偶数行添加，stack2,先加left
                if (temp.left != null){
                    stack2.push(temp.left);
                }
                if (temp.right != null){
                    stack2.push(temp.right);
                }
            }else {
                temp = stack2.pop();
                System.out.print(temp.value+" ");
                //当前为偶数行，给奇数行添加，stack1，先加right
                if (temp.right != null){
                    stack1.push(temp.right);
                }
                if (temp.right != null){
                    stack1.push(temp.left);
                }
            }
            //接下来要判断一下当前的栈是不是空了，空了的话要换行
            if (current == 1){
                if (stack1.isEmpty()){
                    current = 1 - current;
                    System.out.println();
                }
            }else {
                if (stack2.isEmpty()){
                    current = 1 - current;
                    System.out.println();
                }
            }

        }

    }

}












