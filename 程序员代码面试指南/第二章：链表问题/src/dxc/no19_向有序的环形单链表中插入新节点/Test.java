package dxc.no19_向有序的环形单链表中插入新节点;

import dxc.Node;
import dxc.PrintLinkedList;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/24 23:14
 */
public class Test {

    public static void main(String[] args) {
         Node n1 = new Node(1);
         Node n2 = new Node(3);
         Node n3 = new Node(4);

         n1.next = n2;
         n2.next = n3;
         n3.next = n1;

         Node head = InsertCirList.insertCirList(n1,5);
         Node next = head.next;
        System.out.println(head.value);
         while (next!=head){
             System.out.println(next.value);
             next = next.next;
         }

    }
}
