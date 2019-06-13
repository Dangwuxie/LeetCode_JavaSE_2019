/**
 * @author Dangxuchao
 * @Title: Development2
 * @ProjectName leetcode_链表
 * @Description:  成环链表扩展2：如果链表有环，求出入环节点；
 * 假定链表有环
 * 分析：通过实现发现：从链表头节点到入环点的距离，
 * 等于从首次相遇点回到入环点的距离；
 * 思路：当第一次相遇时，将p2指针放在相遇点；
 * 将p1指针放在链表的头节点；然后同时一步一步走，
 * 直到两个指针相遇的时候的节点就是入环点；
 * 返回入环点的节点的值；
 * @date 2019/6/13 17:36
 */
public class Development2 {
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public static int joinLoopNode(Node head){
        return getJoinLoopNodeInter(head).data;
    }
    private static Node getJoinLoopNodeInter(Node head){
        Node p1 = head;
        Node p2 = head;
        boolean flag = true;
        //假定已知链表有环；
        while (p2 != null && p2.next != null){
            //此处一定要注意三个if语句执行的顺序！！！！！
            if (flag == true){
                p1 = p1.next;
                p2 = p2.next.next;
            }else {
                p1 = p1.next;
                p2 = p2.next;
            }

            if (flag == false && p1 == p2){
                break;
            }

            if (p1 == p2 && flag == true){
                p1 = head;
                flag = false;
            }
        }
        return p2;
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
        node7.next = node2;
        System.out.println(joinLoopNode(node1));
    }
}
