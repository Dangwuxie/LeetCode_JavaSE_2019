/**
 * @author Dangxuchao
 * @Title: PrintCommonPart
 * @ProjectName 第二章：链表问题
 * @Description: 题目：打印两个有序链表的公共部分，
 * 给定两个有序链表的头指针head1和head2,打印两个链表的公共部分，
 * 就是说按照顺序打印，碰到相同的元素就打印；
 *
 * 举个例子： 123678 和 245679   就打印出267；这就是相同部分；
 *
 * 分析：因为是有序链表，所以直接从表头开始遍历；
 *
 * 具体过程：
 * 	*
 * 如果head1的值小于head2，则head1往下移动
 * 	*
 * 如果head1的值大于head2，则head2往下移动
 * 	*
 * 如果碰到某一次head1的值与head2的值相等，那么输出它们的值然后同时往下移动；
 * 	*
 * 如果其中一个head移动到null了，那么整个过程就停止；
 * @date 2019/7/6 22:09
 */
public class PrintCommonPart {

    public static class Node{
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }
    public static Node head1 = new Node(null);
    public static Node head2 = new Node(null);

    public static void addNode1(Integer value){
        if (head1.value == null){
            head1.value = value;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head1;
        head1 = newNode;
    }
    public static void addNode2(Integer value){
        if (head2.value == null){
            head2.value = value;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head2;
        head2 = newNode;
    }
    public static void printCommonPart(Node head1,Node head2){
        Node h1 = head1;
        Node h2 = head2;
        System.out.println("链表1为：");
        while (head1!=null){
            System.out.print(head1.value);
            head1 = head1.next;
        }
        System.out.println();
        System.out.println("链表2为：");
        while (head2!=null){
            System.out.print(head2.value);
            head2 = head2.next;
        }

        System.out.println("公共部分为：");

        while (h1!=null&&h2!=null){
            if (h1.value>h2.value){
                h1 = h1.next;
            }else if (h1.value<h2.value){
                h2 = h2.next;
            }else if (h1.value == h2.value){
                System.out.print(h1.value+" ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }
    public static void main(String[] args) {
        addNode1(1);
        addNode1(2);
        addNode1(3);
        addNode1(6);
        addNode1(7);
        addNode1(8);

        addNode2(2);
        addNode2(4);
        addNode2(5);
        addNode2(6);
        addNode2(7);
        addNode2(9);

        printCommonPart(head1,head2);

    }

}

/*
链表1为：
876321
链表2为：
976542公共部分为：
7 6 2

 */











