package dxc.no3_删除链表的中间节点和ab处的节点;

import dxc.Node;

/**
 * @author 灵魂编程者
 * @Title: RemoveMidNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/21 0:14
 */

/*
* 删除链表的中间节点和a/b处的节点
*
* 问题：给定一个链表的head节点，然后删除这个链表的中间节点
* 分析：如果head是null或者只有一个节点，不删除任何节点
*       如果>=两个节点，那么就要删除中间节点，
*       比如，长度2，删第一个，长度3，删除第二个；
* 实现：利用快慢指针，当快指针没有next.next时
*      慢指针也无法继续前进，所以此时需要利用快指针来作为循环条件
*     将慢指针指向next.next;
*
* */
public class RemoveMidNode {

    public static Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return null;
        }

        if (head.next.next == null){
            return head.next;
        }

        //走到此处的时候证明节点数超过2个
        Node pre = head;
        Node cur = head.next.next;

        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }

        pre.next = pre.next.next;

        return head;
    }


    /*
    * 进阶版，就是说给个头节点，再带个a，b，然后a/b的结果
    * 乘以链表的长度，就是要删除的第几个节点；
    *
    *
    * */
    public static Node removeABNode(Node head,int a,int b){
        if (a < 1 || a > b){
            return null;
        }

        //求长度
        int n = 0;
        Node temp = head;
        while (temp != null){
            n++;
            temp = temp.next;
        }
        //Math的ceil函数功能就是四舍五入的功能。
        //此方法就是求需要删除那个节点
        n = (int) Math.ceil( (double)(a*n) / (double)b );
        System.out.println(n);
        if (n == 1){
            return head.next;
        }

        if (n > 1){
            temp = head;
            //找出要删除节点的前一个节点
            while (--n != 1){
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }


        return head;
    }

}
