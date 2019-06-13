/**
 * @author Dangxuchao
 * @Title: IsCycleLinkedList
 * @ProjectName leetcode_链表
 * @Description: 判断链表是否成环
 * @date 2019/6/13 15:31
 */
public class IsCycleLinkedList {
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;
        System.out.println(isCycle(node1));//-->true
        //注释最后行链接
        System.out.println("注释最后一行代码后："+isCycle(node1));//false

    }
}
