/**
 * @author Dangxuchao
 * @Title: ReversePartionList
 * @ProjectName 第二章：链表问题
 * @Description: 反转部分单向链表
 * 题目：给定一个单向链表的头节点，以及两个整数from和to,
 * 在单向链表上把从from个节点到to个节点这一部分进行反转；
 * 例如12345，from=2  to=4;
 * 调整结果是14325；
 * 123，from=1,to=3;
 * 调整结果是321；
 * 如果不满足1<=from<=to<=N;就不调整，直接返回
 *
 * 要求：如果链表长度为N，时间复杂度为O(N),额外空间复杂度为O(1);
 *
 * 解题思路，
 * 1、先保存一下要反转链表部分的前一个节点和后一个节点，反转后要链接；
 * 比如1->2->3->4  此时form=2,to=3;反转之后就是1->3->2->4;
 * 要保存的节点设为fPre  和  tPos;
 * 2、node1为要反转部分的头节点；开始反转，只要要进行反转的节点不是tPos节点，
 * 那么就一直反转下；
 * 3、注意，会存在换头的问题，比如例子中第二个；
 * * @date 2019/7/4 18:39
 */
public class ReversePartionList {
    public static class Node{
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static Node head = new Node(null);
    public static Node HEAD = head;
    public static void addNode(Integer value){
        if (head.value == null){
            head.value = value;
            return;
        }
        Node newNode = new Node(value);

        head.next = newNode;
        head = newNode;
    }

    /*
    反转部分单向链表一部分部分
     */
    public static Node reversePartionList(Node head,int from,int to){
        //首先判断是否满足1<=from<=to<=N

        //先定义fPre,tPos；
        Node fPre = null;
        Node tPos = null;
        int len = 0;//用来计算链表的长度
        //先让node1指向头节点，以便后换头的情况出现,node1用来遍历链表
        Node node1 = head;

        //下面用node1遍历链表找出fPre  tPos
        while (node1 != null){
            len++;//len先加一，从第一个节点开始寻找；
            fPre = len==from-1?node1:fPre;
            tPos = len==to+1?node1:tPos;
            node1 = node1.next;
        }

        //循环完后，以及找到反转部分的前一个节点跟后一个节点了；
        //而且此时也知道了链表的长度，此时需要判断from to满足的关系；
        if (from>to || from<1 || to>len){
            //如果不满足，则不用调整，之间返回head就行了；
            return head;
        }

        //下面就开始要进行这一部分的链表反转了；
        node1 = fPre==null?head:fPre.next;
        Node node2 = node1.next;
        //这一步可以说是很有灵性了，因为此时node1节点在反转之后就成了
        //最后一个节点了，它需要跟yPos节点链接，所以此时直接next指向了tPos;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (fPre!=null){
            fPre.next = node1;
            return fPre;
        }
        return node1;
    }
    public static void printList(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {

        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);

        printList(HEAD);
        System.out.println();
        printList(reversePartionList(HEAD,2,4));

    }
}
