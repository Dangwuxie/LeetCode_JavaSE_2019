package dxc.no17_单链表的选择排序;

import dxc.Node;

/**
 * @author dxc
 * @Title: ListSelectionSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/18 23:12
 */

/*
* 给定一个无序单链表的头节点head，实现单链表的选择排序
*
* */
public class ListSelectionSort {
    /*
    * 要求额外空间复杂度为O(1)，就是要求只能使用仅有的几个变量来实现链表的选择排序
    * 实现思路：首先，第一次遍历链表找到最小的节点，使用一个新的newNode指针遍历指向它，
    * 后面每次找到最小值的Node节点，将它从当前的链表中删除，然后接在已排序部分的链表的末尾
    * 全部过程处理完之后，整个链表已经有序，此时返回newHead；
    * */
    public static Node listSelectionSort(Node head) {

        //用来遍历原始链表的指针
        Node cur = head.next;
        //始终指向已排序链表的最后一个节点
        Node newListNext = null;
        //临时保存原始链表中的最小的节点
        Node small = head;
        Node smallPre = null;

        while (cur != null){
            small = cur;
            smallPre = getSmallestPreNode(cur);

            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            //此时需要判断当前的cur是否就是删除的那个节点
            //如果是，那么cur=cur.next
            //否则cur当前的位置不变
            cur = cur == small ? cur.next : cur;
            //下面就是已排序链表的接入已排序链表的尾部
            if (newListNext == null){
                head = small;
            }else {
                newListNext.next = small;
            }
            newListNext = small;
        }
        return head;
    }
    /*
    * 此方法是获取当前给定的head节点为头节点所在的链表中的最小的节点
    * */
    public static Node getSmallestPreNode(Node head){

        Node smallPre = null;
        Node small = head;
        /*
        * pre和cur一直迭代这往后遍历
        * small和smallPre只有在确定small的时候重新赋值一遍
        * */
        Node pre = head;
        Node cur = head.next;

        while (cur != null){
            if (small.value > cur.value){
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        //返回当前链表中最小节点的前一个节点
        return smallPre;
    }
}







