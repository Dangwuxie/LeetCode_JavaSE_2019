package dxc.no9_将单向链表按照某值划分左小中相等右边大的形式;

import dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: ListPartition
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/17 16:35
 */

/*
* 题目：给你一个链表head和一个数pivot，然后让你按照小于、等于、大于
* pivot的顺序将链表重新排序；时间复杂度为On  空间为ON
*
* 进阶要求：小于、等于、大于部分还必须按照之前链表的前后顺序排序；
* 时间复杂度依旧为ON,但是空间复杂度变成O1
* */
public class ListPartition {

    /*
    * 1、初始问题的解决思路：创建一个节点数组，遍历一遍链表
    * 把节点全部放进去，数组采用类似快排的方式重新排列数组
    * 然后从数组第一个元素开始到最后一个元素一次串接起来；
    * */
    public static Node listPartition1(Node head,int pivot){

        if (head == null){
            return null;
        }
        //统计链表长度，创建数组
        int i = 0;
        Node cur = head;

        while (cur != null){
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        cur = head;
        i = 0;

        while (cur != null){
            nodeArr[i++] = cur;
            cur = cur.next;
        }
        //此时需要调用partition函数实现类似快排的功能
        arrPartition(nodeArr,pivot);
        //然后从数组第一个元素开始依次连接节点
        for (i=1;i<nodeArr.length;i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        //重新
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;

        while (index != big){
            if (nodeArr[index].value < pivot){
                swap(nodeArr,++small,index++);
            }else if (nodeArr[index].value == pivot){
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }

    public static void swap(Node[] nodeArr,int a,int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    /*
    * 进阶2:利用仅有的几个变量实现，时间复杂度ON,空间复杂度变为O1
    * 思路：将链表依次分割成三个小的链表，最后按照顺序连接起来
    *
    * */

    public static Node listPartition2(Node head,int pivot){
        //定义六个Node指针
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        /*
        * 注意对null节点的变化；就是说每遍历到一个节点都要把它下一个指向变成null
        * */
        while (head != null){

            next = head.next;
            head.next = null;

            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }

            head = next;
        }
        //开始连接
        if (sT != null){
            sT.next = eH;
            eT = eT == null?sT:eT;
        }

        if (eT != null){
            eT.next = bH;
        }

        return sH != null ? sH : eH != null ? eH : bH;
    }
}








