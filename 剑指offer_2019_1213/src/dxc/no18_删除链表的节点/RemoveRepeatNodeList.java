package dxc.no18_删除链表的节点;

import dxc.Node;

/**
 * @author dxc
 * @Title: RemoveRepeatNodeList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/24 17:11
 */
/*
* 删除链表中重复的节点；有重复就全部删除，重复的节点是连接在一起的；
* 1-2-2-3-4-4;删除之后，1-3;
* 解题思路：首先要考虑，重复的节点在首、中、尾的三种情况，
* 还有链表中的所有节点都是重复的，
* 没有重复节点
* */
public class RemoveRepeatNodeList {
    /*
    *
    * */
    public static Node removeRepeatNodeList(Node head){

        Node preNode = null;//preHead始终指向的是不重复节点中的最后一个节点
        Node curNode = head;

        while (curNode != null){

            if (curNode.next != null && curNode.value != curNode.next.value){
                preNode = curNode;

            }else if (curNode.next == null){
                preNode.next = curNode;
            }else {
                //此时说明curNode与下一个节点重复
                while (curNode.next != null && curNode.value == curNode.next.value){
                    curNode = curNode.next;
                }
                //当上面的额while循环出来的时候，curNode的下一个节点就是不重复的第一个节点
                if (preNode == null){
                    preNode = curNode.next;
                    head = preNode;
                }else {
                    preNode.next = curNode.next;
                }
                System.out.println("删除"+curNode.value);
            }

            curNode = curNode.next;
        }
        if (preNode.next == null){
            System.out.println("删除完毕！");
            return null;
        }
        return head;
    }
}
/*
    删除1
    删除4
    删除5
    删除8
    删除完毕！
    链表为空！！！
*/







