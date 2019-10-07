package com.dxc.no4_二叉树的序列化和反序列化;

import com.dxc.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 灵魂编程者
 * @Title: SerialByPre
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/7 23:14
 */

/*
* 通过先序遍历序列化二叉树以及反序列化
* 思路：序列化的时候，为了后面反序列化的时候不会产生歧义，需要加上个结束符号
* 如果是数字，就是数字加上!,如果节点的孩子为空，就序列化成"*!";
*
* 反序列化的时候，先使用String的split方法，返回字符数组
* 然后构建二叉树，
* */
public class SerialByPre {

    public static String serialByPre(Node head){
        if (head == null){
            return "*!";
        }

        String res = head.value+"!";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }

    public static Node reconByPreSerial(String preStr){
        //首先以“！”分隔开
        String[] strings = preStr.split("!");
        //此处构建二叉树需要递归，但是数组实现递归不方便，
        //可以使用队列来解决此问题
        Queue<String> queue = new LinkedList<>();
        for (int i=0;i<strings.length;i++){
            queue.offer(strings[i]);
        }
        //完了之后使用一个方法来实现递归操作
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        //此方法内部实现递归
        String value = queue.poll();
        if (value.equals("*")){
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);

        return head;
    }
}
