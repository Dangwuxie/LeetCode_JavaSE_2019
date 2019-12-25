package dxc.no20_合并两个有序的单链表;

import dxc.Node;

/**
 * @author dxc
 * @Title: MergeOrderlyList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/25 20:40
 */
/*
* 合并两个有序的单链表；
* */
public class MergeOrderlyList {

    /*
    * 思路：时间复杂度为O(n);额外空间复杂度为O(1);
    * 两个指针，cur1，cur2，cur1一直指向head小的链表，
    * pre和next指针，pre一直指向已合成链表的最后一个节点，所以pre从cur1的head开始；
    * next用来保存每次删除某个链表的节点之后的下一个节点；
    * 就相当于pre从cur1的head节点开始每次指向两个节点剩余节点中的最小值，
    * S型的一直往下指向；
    *
    * */
    public static Node mergeOrderlyList(Node head1,Node head2){

        //首先，如果其中一个链表为null，直接返回另外一个链表头节点
        if (head1 == null || head2 == null){
            return head1 == null ? head1 : head2;
        }
        //下面是定义四个指针，cur1一直指向的是head小的链表节点，
        //因为这个节点必定是合成后的链表第一个节点
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head1 == head ? head1 : head2;
        Node cur2 = head1 == head ? head2 : head1;

        Node pre = null;
        Node next = null;

        while (cur1 != null && cur2 != null){
            if (cur1.value <= cur2.value){
                //如果进入此判断框，那么就是直接将pre直接移动到当前的cur1上
                //然后cur1 = cur1.next;
                pre = cur1;
                cur1 = cur1.next;
            }else {
                //此时需要将cur2中的节点插入到链表中
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;//每次这样就相当于将cur2中的节点插入到cur1当中去；
                pre = cur2;
                cur2 = next;
            }
        }
        //最后肯定cur1或者cur2有一个为null了
        //如果是cur1为null，说明cur2没有插完，将cur2剩下的节点连接在cur1(当前pre的指向)后面；
        //如果是cur2为null，说明已经插完了，直接返回head就行
        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }
}








