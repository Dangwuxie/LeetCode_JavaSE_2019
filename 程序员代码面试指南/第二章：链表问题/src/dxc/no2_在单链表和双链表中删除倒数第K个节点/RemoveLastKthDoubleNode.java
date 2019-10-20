package dxc.no2_在单链表和双链表中删除倒数第K个节点;

/**
 * @author 灵魂编程者
 * @Title: RemoveLastKthDoubleNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/20 23:01
 */

/**
 * @author Dangxuchao
 * @Title: dxc.no2_在单链表和双链表中删除倒数第K个节点.RemoveLastKthDoubleNode1
 * @ProjectName 第二章：链表问题
 * @Description: 删除双链表中倒数第K个节点
 * 做法跟单链表的步骤基本一致，但是要注意的是
 * 删除节点的前驱节点链接到后继节点的时候，不但使per.next链接nexe,
 * 而且是要后继节点的last指向前驱节点；
 * @date 2019/7/7 8:29
 */
public class RemoveLastKthDoubleNode {
    public static DoubleNode head = new DoubleNode(null);
    public static class DoubleNode{
        public Integer value;
        public DoubleNode next;
        public DoubleNode pre;

        public DoubleNode(Integer value) {
            this.value = value;
        }
    }
    public static void addDoubleNode(Integer value){
        if (head.value == null){
            head.value = value;
            return;
        }
        DoubleNode newNode = new DoubleNode(value);
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
    }
    public static DoubleNode removeDoubleNode(Integer k){
        if (k < 1){
            return head;
        }
        DoubleNode head1 = head;
        //下面就是第一遍遍历链表，然后K--；
        while (head1!=null){
            k--;
            head1 = head1.next;
        }
        if (k > 0){
            return head;
        }else if (k == 0){
            return head.next;
        }else {
            //此时就是k小于0的情况了
            //再次遍历
            DoubleNode tempNode = head;
            while (++k != 0){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            //tempNode.next.next.pre = tempNode;
            if(tempNode.next.next != null){
                tempNode.next.next.pre = tempNode;
            }
            //DoubleNode next = tempNode.next.next;
            //tempNode.next = next;
            //if (next != null){
            //    next.pre = tempNode;
            //}
        }
        return head;
    }
    public static void printList(DoubleNode head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        addDoubleNode(5);
        addDoubleNode(4);
        addDoubleNode(3);
        addDoubleNode(2);
        addDoubleNode(1);
        printList(removeDoubleNode(1));


    }

}
