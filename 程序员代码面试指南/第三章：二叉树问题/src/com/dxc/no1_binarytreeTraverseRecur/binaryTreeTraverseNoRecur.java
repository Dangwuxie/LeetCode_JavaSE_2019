package com.dxc.no1_binarytreeTraverseRecur;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: binaryTreeTraverseNoRecur
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/9 10:47
 */

/*二叉树的三种非递归的遍历方法*/
public class binaryTreeTraverseNoRecur {

    public static void preOrder(Node head){
        if (head != null){
            //利用栈实现
            Stack<Node> preStack = new Stack<>();
            preStack.push(head);

            while (!preStack.isEmpty()){
                Node temp = preStack.pop();
                System.out.print(temp.value);
                if (temp.right != null){
                    preStack.push(temp.right);
                }
                if (temp.left != null){
                    preStack.push(temp.left);
                }
            }
        }

    }

    public static void inOrder(Node head){
        /*
        * 中序遍历的思路：一路left下去，为null的时候开始弹出，
        * 第一个弹出的就是最后一个左节点，弹出后获取这个节点的right节点，
        * 右节点如果后面有节点，继续left下去，如果没有就输出value，
        * 为空的话就继续弹出，继续前面的套路；
        * while循环条件就是(栈不为空，或者当前的head节点不为空)
        * */
        if (head != null){
            Stack<Node> inStack = new Stack<>();
           while (!inStack.isEmpty() || head != null){
                if (head != null){
                    inStack.push(head);
                    head = head.left;
                }else {
                    head = inStack.pop();
                    System.out.print(head.value);
                    head = head.right;
                }
           }
        }
        System.out.println("----------------------------");
    }

    public static void posOrder1(Node head){
        //第一种方式：通过两个栈实现
        //第一个栈就是非递归的变种前序遍历弹出元素，弹入第二个栈
        //然后s2出栈顺序就是后续遍历
        if (head != null){
            Stack<Node> posStack1 = new Stack<>();
            Stack<Node> posStack2 = new Stack<>();
            //先按照中左右的顺序压入s1
            posStack1.push(head);

            while (!posStack1.isEmpty()){
                Node cur = posStack1.pop();
                posStack2.push(cur);

                //注意这两个左右节点压入S1的顺序，弹出来弹到S2后，
                //出栈的顺序应该是先左后右，所以s1的栈顶节点应该是右节点在左节点前面
                if (cur.left != null){
                    posStack1.push(cur.left);
                }
                if (cur.right != null){
                    posStack1.push(cur.right);
                }
            }

            while (!posStack2.isEmpty()){
                System.out.print(posStack2.pop().value);
            }
        }
    }

    public static void posOrder2(Node head){
        //一个栈实现
        if (head != null){
            Stack<Node> posStack3 = new Stack<>();
            /*
            * 思路实现：就是利用一个栈，一直压left，到最后一个left的时候
            * 判断有没有子right，有的话就继续压入，
            * 直到没有孩子的节点出现，先用C保存当前要弹出的节点，然后弹出并且打印
            * */
            posStack3.push(head);
            Node c = null;
            while (!posStack3.isEmpty()){
                head = posStack3.peek();
                if (head.left!=null && c != head.left && c != head.right){
                    posStack3.push(head.left);
                }else if (head.right != null && c != head.right){
                    posStack3.push(head.right);
                }else {
                    c = head;
                    System.out.print(posStack3.pop().value);
                }
            }
        }
    }
}
