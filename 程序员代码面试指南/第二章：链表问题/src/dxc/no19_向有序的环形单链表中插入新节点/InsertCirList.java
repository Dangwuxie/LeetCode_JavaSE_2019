package dxc.no19_向有序的环形单链表中插入新节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: InsertCirList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/24 23:16
 */

/*
* 题目要求：向有序(升序)的环形单链表中插入新节点
* 给定head和一个值num，请生成一个值为num的新节点插入环形链表中
* 并且不改变链表的有序性；
*
* 时间复杂度为O(N),空间复杂度为O(1)
* */
public class InsertCirList {
    /*
    * 思路，由于是升序的环形单向链表，可以用两个指针pre和cur从head和head.next开始遍历
    * 如果碰到pre.value<=num<cur的，就生成一个链表插入其中，
    * 如果循环一遍下来后没有出现此情况，那么就说明要么比链表中的所有值都小，要么都大；直接插在头节点的前面；
    * 就是首尾相接的地方；
    * */
    public static Node insertCirList(Node head,int num){
        Node newNode = new Node(num);

        if (head == null){
            //如果head为null，那么num自己new一个节点指向自己；
            newNode.next = newNode;
            return newNode;
        }
        //否则就迭代的往后遍历，然后找合适的位置
        Node pre = head;
        Node cur = head.next;

        while (cur != head){

            if (pre.value <= num && cur.value > num){
                pre.next = newNode;
                newNode.next = cur;
                return head;
            }

            pre = pre.next;
            cur = cur.next;
        }
        //此时就是没有找到合适的位置，此时cur指向了head，pre指向了最大的Node节点
        pre.next = newNode;
        newNode.next = head;

        //由于此时不知道newNode的值是最大的还是最小的，需要判断一下
        return cur.value > num ? newNode : cur;
    }
}






