package dxc.no22_链表中倒数第k个节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: KNodeOfList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/30 16:02
 */
/*
* 输入一个head节点和k，求该链表的倒数第k个节点
* 比如1，2，3，4，5；倒数第三个节点就是3；
* */
public class KNodeOfList {
    /*
    * 最简单的解法就是遍历一遍，得出链表长度
    * 再遍历一遍，然后求出n-k+1个节点
    * */
    /*
    * 遍历一遍的思路，移动窗口法，就是两个指针卡位置
    * 当右边的指针到最后一个节点的时候，左边的指针刚好就在倒数第k个节点上
    * 左右指针的距离刚好就是k；
    * */
    public static Node findKNodeList(Node head,int k){

        if (head == null || k == 0){
            try {
                throw new Exception("输入出错！请重新输入！");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        Node left = head;
        Node right = head;
        //先让right指针与left指针的距离达到k
        for (int i = 0;i < k-1;i++){
            if (right.next != null){
                right = right.next;
            }else {
                try {
                    throw new Exception("链表长度不够");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        //此时left刚好指在倒数第k个节点上
        return left;
    }
}
