package dxc.no10_复制含有随机指针节点的链表;

import dxc.PrintLinkedList;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/6 22:21
 */
public class Test {

    public static void main(String[] args) {
        RandNode n1 = new RandNode(1);
        RandNode n2 = new RandNode(2);
        RandNode n3 = new RandNode(3);
        n1.next = n2;
        n2.next = n3;
        n1.rand = n3;
        n2.rand = null;
        n3.rand = n1;

        printLinkedList(CopyListWithRand.copyListWithRand(n1));

    }

    public static void printLinkedList(RandNode head){
        if (head == null){
            return;
        }
        RandNode temp = head;

        while (temp != null){
            System.out.print(temp.value + " ");
            if (temp.rand != null){
                System.out.print(temp.rand.value);
            }
            temp = temp.next;
            System.out.println();
        }
    }

    /*
    *
    *   1 3
        2
        3 1
    * */
}
