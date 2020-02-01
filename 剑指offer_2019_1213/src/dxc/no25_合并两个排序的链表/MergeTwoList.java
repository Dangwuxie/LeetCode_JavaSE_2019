package dxc.no25_合并两个排序的链表;

import dxc.Node;

/**
 * @author dxc
 * @Title: MergeTwoList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/1 16:30
 */

/*
* 题目要求，合并两个递增排序的链表，合成之后依旧递增；
* */
public class MergeTwoList {
    /*
    * 思路：递归的方法来解题：
    *
    * */
    public static Node mergeList(Node head1,Node head2){

        if (head1 == null){
            return head2;
        }else if (head2 == null){
            return head1;
        }

        Node mergeHead = null;
        if (head1.value < head2.value){
            //链表1的头节点小于链表2截取当前的节点，、
            //继续递归下一个list1的节点，和list2当前的节点
            mergeHead = head1;
            mergeHead.next = mergeList(head1.next,head2);
        }else {
            mergeHead = head2;
            mergeHead.next = mergeList(head1,head2.next);
        }

        return mergeHead;
    }

    /*
    * 非递归实现(循环)
    * */
    public static Node mergeList2(Node head1,Node head2){

        if (head1 == null){
            return head2;
        }else if (head2 == null){
            return head1;
        }
        //next1指向最开始头节点最小的链表
        Node next1 = head1.value < head2.value ? head1 : head2;
        Node next2 = head1.value < head2.value ? head2 : head1;
        Node mergeHead = next1;
        Node mergeLast = next1;
        next1 = next1.next;

        while (next1 != null && next2 != null){

            if (next1.value < next2.value){
                mergeLast.next = next1;
                mergeLast = next1;
                next1 = next1.next;
            }else {
                mergeLast.next = next2;
                mergeLast = next2;
                next2 = next2.next;
            }
        }
        //此处需要判断一下，肯定有一个链表还没有遍历完，最后直接连接到就行
        mergeLast.next = next1 == null ? next2 : next1;

        return mergeHead;
    }
}










