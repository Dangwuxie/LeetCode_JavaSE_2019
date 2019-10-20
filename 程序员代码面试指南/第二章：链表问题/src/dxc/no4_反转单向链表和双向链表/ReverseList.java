package dxc.no4_反转单向链表和双向链表;

/**
 * @author Dangxuchao
 * @Title: dxc.no4_反转单向链表和双向链表.ReverseList
 * @ProjectName 第二章：链表问题
 *
 * @Description: 反转单向链表
 * 返回新链表的头节点
 * @date 2019/7/3 20:15
 */
public class ReverseList {
    public static Node head = new Node(null);
    public static Node HEAD = head;//尾插法时保存头节点指针；
    public static void main(String[] args) {
        addLastNode(1);
        addLastNode(2);
        addLastNode(3);
        addLastNode(4);
        addLastNode(5);
        addLastNode(6);
        addLastNode(7);
        printList(HEAD);
        System.out.println();
        printList(reverseList(HEAD));
    }

    public static class Node{
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static void addFirstNode(Integer value){
        //头插法
        if (head.value == null){
            head.value = value;
            return;
        }
        Node newNode = new Node(value);

        newNode.next = head;

        head = newNode;
    }
    public static void addLastNode(Integer value){
        //尾插法
        if (head.value == null){
            head.value = value;
            return;
        }

        Node newNode = new Node(value);

        head.next = newNode;

        head = newNode;
    }
    public static void printList(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }

    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;

        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
