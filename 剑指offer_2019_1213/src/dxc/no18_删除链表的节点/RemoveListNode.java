package dxc.no18_删除链表的节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: RemoveListNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/23 22:43
 */
/*
* 题目要求：再O(1时间内删除链表节点)
* 给定一个头节点和要删除的数字
* */
public class RemoveListNode {
    /*
    * 思路：最直接的方法就是遍历一遍找到要删除节点的前一个节点
    * 然后将其指向下下个节点就行了；可是这样需要遍历节点，需要O(N)的时间复杂度
    *
    * 可以这样做，让当前节点的下一个节点的值覆盖当前的节点，
    * 然后将当前的节点的next指针指向下下个节点；
    * 这种方法需要考虑：要删除的是尾节点，只能从头到尾遍历
    * 如果链表只有一个节点，要删除的恰好是这个节点，删除后需要将当前的节点指向null
    * */
    public static Node removeListNode(Node head,Node deletedNode){

        if (deletedNode.next != null){
            deletedNode.value = deletedNode.next.value;
            deletedNode.next = deletedNode.next.next;
        }else if (head.value == deletedNode.value){
            head = null;
        }else {
            //链表中有多个节点，删除尾节点
            Node preNode = head;
            while (preNode.next.value != deletedNode.value){
                preNode = preNode.next;
            }
            //此时preNode指向的就是要删除的节点
            preNode.next = null;
        }

        return head;
    }

}
