package dxc2.no35_复杂链表的复制;

import java.util.HashMap;

/**
 * @author dxc
 * @Title: CopyOfListWithRand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/8 14:08
 */
/*
* 复杂链表节点，除了一个next指针，还有一个随机指针sib，
* 随机指向链表内的任意一个节点或者null,
* 要求复制这样一个链表，然后返回复制链表的头节点
* */
public class CopyOfListWithRand {
    /*
    * 第一种方法：
    * O(N)的时间复杂度和空间复杂度，利用哈希表实现
    * 第一遍遍历存入对应的复制链表节点
    * 第二遍遍历，复制sib随机指针
    * */
    public static RandNode copyOfList(RandNode head){

        if (head == null){
            return null;
        }

        RandNode cur = head;
        HashMap<RandNode,RandNode> map = new HashMap<>();

        while (cur != null){
            map.put(cur,new RandNode(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            //第二遍遍历，连接next指针和sib随机指针
            map.get(cur).next = map.get(cur.next);
            map.get(cur).sib = map.get(cur.sib);
            cur = cur.next;
        }

        return map.get(head);
    }

    /*
    * 第二种方法：利用有限的几个变量实现复制
    * 思路：将复制后的节点连接在原链表里每个原节点的后面
    * 然后复制sib随机指针,由于在同一个链表里面
    * 所以可以直接指向，最后拆分
    * */
    public static RandNode copyOfList2(RandNode head){

        if (head == null){
            return null;
        }

        RandNode cur = head;
        RandNode next = null;
        //将每个原节点的复制节点挂在后面。连成一串
        while (cur != null){
            next = cur.next;
            cur.next = new RandNode(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;

        //下面就是复制rand指针了
        while (cur != null){
            next = cur.next;
            next.sib = cur.sib != null ? cur.sib.next : null;
            //判断一下当前的copyNode的next节点是不是null，不是的话就说明还存在原节点
            cur = next.next;
        }
        //下面就是拆分了，拆分的同时复制了next指针
        cur = head;
        //保存一下复制链表的头节点
        RandNode res = head.next;
        RandNode copyNode = null;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            //当前的复制节点指向下一个复制节点,此处需要判断next是否为空
            copyNode.next = next != null ? next.next : null;
            //当前的原节点指向下一个原节点
            cur.next = next;
            cur = next;
        }

        return res;
    }


}










