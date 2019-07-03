/**
 * @author Dangxuchao
 * @Title: ReverseDoubleList
 * @ProjectName 第二章：链表问题
 * @Description:
 * 反转双向链表
 * 返回新链表的头节点
 * @date 2019/7/3 20:16
 */
public class ReverseDoubleList {

    public static DoubleNode head = new DoubleNode(null);
    public static DoubleNode HEAD = head;
    public static class DoubleNode{
        public Integer value;
        public DoubleNode pre ;
        public DoubleNode next;

        public DoubleNode(Integer value) {
            this.value = value;
        }
    }

    public static void addFirstDoubleNode(Integer value){
        //头插
        if (head.value == null){
            head.value = value;
            return;
        }

        DoubleNode newNode = new DoubleNode(value);

        head.pre = newNode;
        newNode.next = head;

        head = newNode;
    }
    public static void addLastDoubleNode(Integer value){
        //尾插
        if (head.value == null){
            head.value = value;
            return;
        }

        DoubleNode newNode = new DoubleNode(value);

        head.next = newNode;
        newNode.pre = head;
        head = newNode;
    }

    public static void printList(DoubleNode head){
        if (head.next!=null){
            while (head!=null){
                System.out.print(head.value+" ");
                head = head.next;
            }
        }else {
            while (head!=null){
                System.out.print(head.value+" ");
                head = head.pre;
            }
        }
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        if (head.pre == null){
            while (head!=null){
                next = head.next;
                head.next = pre;
                head.pre = next;
                pre = head;
                head = next;
            }
            return pre;
        }else {
            while (head!=null){
                pre = head.pre;
                head.pre = next;
                head.next = pre;

                next = head;
                head = pre;
            }
            return next;
        }

    }
    public static void main(String[] args) {
        //此时用的是头插法，就是说1的pre是2-----，1的next=null;
        addFirstDoubleNode(1);
        addFirstDoubleNode(2);
        addFirstDoubleNode(3);
        addFirstDoubleNode(4);
        addFirstDoubleNode(5);
        printList(head);
        System.out.println();
        printList(reverseDoubleList(HEAD));
    }


}
