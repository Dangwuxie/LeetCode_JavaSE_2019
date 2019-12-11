package dxc.no14_删除无序单链表中值重复出现的节点;

import dxc.Node;

import java.util.HashSet;

/**
 * @author 灵魂编程者
 * @Title: RemoveRep
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/11 21:25
 */
/*
* 题目要求：给定一个无序单链表的head，删除其中重复出现的值的节点
*
* */
public class RemoveRep {

    /*
    * 方法1：利用哈希表，从head开始遍历，每次都判断当前节点的值
    * 是不是等于哈希表的的存有的值，如果存在，就删除当前的节点
    * 否则就存入当前的节点值，定义一个pre指针，一直指向最近一个没有被删除的节点
    * 用来删除当前节点的时候使用
    * */
    public static void removeRepNodes1(Node head){
        if (head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        //首先，head的值肯迪是第一个存入set里面的
        set.add(head.value);
        while (cur != null){
            if (set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                //pre时刻更新，指向最近一个没有被删除的节点
                pre = cur;
            }
            cur = cur.next;
        }
    }
    /*
    * 方法2：使用类似选择排序的过程，从第一个节点开始
    * 定义三个指针，cur、pre、next，cur每往后遍历一个节点
    * pre和next就需要往后循环删除value等于当前节点的值的节点
    * 删除方法：pre = next.next,next=next.next;
    *
    * 此方法的额外空间复杂度为O(1)
    * */
    public static void removeRepNodes2(Node head){
        if (head == null){
            return;
        }

        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            //每次cur往后遍历一个节点
            //pre和next就要从当前cur节点和
            //cur.next开始往后遍历删除相同节点
            pre = cur;
            next = cur.next;
            while (next != null){
                if (cur.value == next.value){
                    pre.next = next.next;
                }else {
                    //否则pre移动到next处，next继续后移
                    pre = next;
                }
                next = next.next;
            }

            cur = cur.next;
        }
    }
}





