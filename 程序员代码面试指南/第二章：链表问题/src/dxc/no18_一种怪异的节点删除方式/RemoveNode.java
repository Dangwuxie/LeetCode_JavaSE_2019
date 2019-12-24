package dxc.no18_一种怪异的节点删除方式;

import dxc.Node;

/**
 * @author dxc
 * @Title: RemoveNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/24 22:57
 */
/*
* 题目要求：给定链表中的节点node，不是头节点，让删除链表中给定的这个节点；
* */
public class RemoveNode {
    /*
    * 思路：如果不是最后一个节点，那么可以直接让当前的节点指向next.next
    * 所以这种方法无法删除最后一个节点。如果是最后一个节点，则无法删除
    * 因为最后一个节点，无法找到它的上一个节点，也就无法让上一个节点指向
    * null。也不能让当前的这个节点变成null，因为null在系统中是一个特定的区域，
    * 如果让前一个节点指向null，则必须找到前一个节点;
    * */
    public static void removeNode(Node node){

        if (node == null){
            return;
        }

        Node next = node.next;
        if (next == null){
            throw new RuntimeException("当前节点是最后一个节点，无法删除！");
        }
        //就是把当前节点的值变成后一个节点的值
        //当前节点指向后一个节点的后一个节点；
        node.value = next.value;
        node.next = next.next;

    }
}
