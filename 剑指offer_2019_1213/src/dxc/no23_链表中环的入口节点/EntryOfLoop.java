package dxc.no23_链表中环的入口节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: EntryOfLoop
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/31 15:47
 */
/*
* 题目要求，找出链表中环的入口
* */
public class EntryOfLoop {
    /*
    * 思路：类似于找倒数第k个节点，用移动窗口找，
    * 先获取环中节点的数目k，然后两个指针，left，right
    * right指针先走k步，然后left再同时出发，当right走了一圈
    * 回到环的入口的时候，left刚好也指在入口处，此时两个指针指在同一个节点
    * 此时就找到入口节点了；
    *
    * 第一步：判断是否有环：快慢指针法
    * 第二步：环内节点个数(然后窗口法找到环的入口)
    * */
    public static Node findEntryOfLoop(Node head){

        Node meetNode = meetNode(head);
        if (meetNode == null){
            try {
                throw new Exception("链表不存在环！");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        //从当前的节点开始遍历，当前的节点就在环中
        int nodesOfLoop = 1;
        Node curNode = meetNode;
        while (curNode.next != meetNode){
            curNode = curNode.next;
            nodesOfLoop++;
        }
        //此时已经取得环的节点数，那么按照窗口法来操作
        Node left = head;
        Node right = head;
        for (int i = 0;i < nodesOfLoop; i++){
            right = right.next;
        }

        while (left != right){
            left = left.next;
            right = right.next;
        }

        return right;
    }

    private static Node meetNode(Node head){
        if (head == null){
            try {
                throw new Exception("链表为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Node pSlow = head;
        Node pFast = head;

        while (pFast.next.next != null && pSlow.next != null){

            pFast = pFast.next.next;
            pSlow = pSlow.next;

            if (pFast == pSlow){
                return pFast;
            }
        }
        //如果上面没有出现pFast和pLast相等的情况，那么就是没有环
        return null;
    }
}







