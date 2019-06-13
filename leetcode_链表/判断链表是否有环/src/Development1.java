/**
 * @author Dangxuchao
 * @Title: Development1
 * @ProjectName leetcode_链表
 * @Description: 成环链表扩展1，求环的长度；
 * 思路：因为两个指针速度差一倍，所以当第一次相遇开始，到下一次相遇，慢指针刚好差了快指针一圈，
 *
 * @date 2019/6/13 17:08
 */

public class Development1 {
    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int loopLength(Node head){
        Node p1 = head;
        Node p2 = head;
        boolean flag = true;
        int p1Foot = 0;
        int p2Foot = 0;
        while (p2 != null && p2.next != null){
            //此处要注意三个if语句的执行顺序；
            //技术语句一定放在最前面执行，因为如果这是最后一个循环
            //就是这次进入循环会发现两指针再次相遇，所以会break，
            //但是在break之前还需要加上最后走的步数；
            if (flag == false){
                p1Foot += 1;
                p2Foot += 2;
            }
            p1 = p1.next;
            p2 = p2.next.next;
            if (flag == false && p1 == p2){
                break;
            }

            if (p1 == p2 && flag == true){
                flag = false;
            }

        }
        return (p2Foot-p1Foot);
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
        System.out.println(loopLength(node1));
    }
}
