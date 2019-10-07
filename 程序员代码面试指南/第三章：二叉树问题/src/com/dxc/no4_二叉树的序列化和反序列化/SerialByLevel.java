package com.dxc.no4_二叉树的序列化和反序列化;

import com.dxc.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 灵魂编程者
 * @Title: SerialByLevel
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/8 0:33
 */

/*
* 层序遍历二叉树的序列化过程
* */
public class SerialByLevel {

    public static String serialByLevel(Node head){
        //首先需要判空
        if (head == null){
            return null;
        }

        String res = head.value+"!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()){
            head = queue.poll();
            if (head.left != null){
                res += head.left.value+"!";
                queue.offer(head.left);
            }else {
                res += "*!";
            }

            if (head.right != null){
                res += head.right.value+"!";
                queue.offer(head.right);
            }else {
                res += "*!";
            }

        }

        //此时代表已经遍历完整个二叉树
        return res;
    }

    public static Node reconByLevelString(String str){
        /* 1!2!3!4!*!*!5!*!*!*!*! */
        //注意，最后一行的*是直接生成null的节点的
        //首先split来生成一个字符串数组
        String[] strings = str.split("!");
        //然后放进队列
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        Node head = getNextNode(strings[index++]);
        if (head != null){
            queue.offer(head);
        }

        Node node = null;
        while (!queue.isEmpty()){
            //层序构建二叉树的过程
            //把头节点出队给node
            node = queue.poll();
            //全局变量index不断网后遍历，层序构建二叉树

            node.left = getNextNode(strings[index++]);
            node.right = getNextNode(strings[index++]);

            //每次判断子节点是不是null，不是的话入队
            //以便下一次while循环之后继续构建
            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }

        return head;
    }

    public static Node getNextNode(String str){
        if (str.equals("*")){
            return null;
        }
        return new Node(Integer.valueOf(str));
    }
}
