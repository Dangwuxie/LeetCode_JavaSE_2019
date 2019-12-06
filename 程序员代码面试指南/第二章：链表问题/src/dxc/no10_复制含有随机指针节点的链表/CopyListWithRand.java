package dxc.no10_复制含有随机指针节点的链表;


import java.util.HashMap;

/**
 * @author 灵魂编程者
 * @Title: CopyListWithRand
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/6 22:33
 */

/*
* 题目要求：给定一个链表list头节点head，链表节点有两个指针，
* 一个就是常见的next指针，另外一个特殊指针rand随机指向任何一个节点，也可能指向null
* 请根据节点的构造，复制一个一模一样的链表list'并且返回头节点；
*
* */

public class CopyListWithRand {

    /*
    * 第一种思路：O(n)的时间复杂度和空间复杂度；
    * 利用map结构，遍历两次链表，
    * 遍历第一次，map记录原链表节点跟复制后的链表节点的关系
    * 1-2-3-null;
    * 1.rand = 3;
    * 2.rand = null;
    * 3.rand = 1;
    * 遍历第二遍，给复制后的节点的next和rand指针赋值
    * */
    public static RandNode copyListWithRand(RandNode head){
        HashMap<RandNode,RandNode> map = new HashMap<>();
        RandNode cur = head;
        //此while循环第一遍遍历，放入map键值对
        while (cur != null){
            map.put(cur,new RandNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        //第二遍，key-value键值对中的value节点，赋值
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /*
    * 第二种思路：o(n)的时间复杂度，仅用有限的几个变量完成所要实现的函数
    * 这种方法不好想到，但也是一种非常优秀的思路，值得细品；
    * 实现思路：第一次遍历链表的时候把每个复制节点连接在原节点的后面，
    * 第二遍遍历，设置rand指针；
    * 然后分离链表，因为每个节点跟copyNode都是连着的，然后可以依次分离
    * 1-2-3;
    * 1-1'-2-2'-3-3'-null;就照着这样分离就行；
    * */
    public static RandNode copyListWithRand2(RandNode head){
        if (head == null){
            return null;
        }

        RandNode cur = head;
        RandNode next = null;
        //首先，将copyNode连接在源节点的后面
        while (cur != null){
            next = cur.next;
            cur.next = new RandNode(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //下面设置每个复制节点copyNode的rand指针；
        cur = head;
        //保存一下复制链表的首节点，最后直接返回
        RandNode res = head.next;
        while (cur != null){
            next = cur.next.next;
            //细品，细品，想一想就能明白
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //下面就是拆分
        cur = head;
        RandNode copyNode = null;
        while (cur != null){
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            //这里必须判断当前的cur是不是最后一个原节点，如果是的话就复制为null;
            //未来防止空指针异常
            copyNode.next = next != null ? next.next:null;
            cur = next;
        }
        return res;
    }
}
