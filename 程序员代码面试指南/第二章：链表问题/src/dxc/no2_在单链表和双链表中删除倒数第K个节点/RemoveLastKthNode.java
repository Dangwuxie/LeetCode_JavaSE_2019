package dxc.no2_在单链表和双链表中删除倒数第K个节点;

/**
 * @author 灵魂编程者
 * @Title: RemoveLastKthNode
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/20 23:03
 */

/**
 * @author Dangxuchao
 * @Title: dxc.no2_在单链表和双链表中删除倒数第K个节点.RemoveLastKthNode1
 * @ProjectName 第二章：链表问题
 * @Description: 删除单链表的倒数第K个节点，并且返回删除节点后的链表的头节点
 * 分析：可以分成三种情况：
 * 1、倒数第K个节点根本部存在，超出链表长度，直接返回false；
 * 比如1->2->3，k=4，链表从头开始遍历，每遍历一个元素k--，
 * 然后此时遍历完之后,k的变化是3->2->1,k此时等于1，大于0，此时倒数第K个节点部存在；
 * 2、倒数第K个节点刚好就是头节点，然后直接返回第二个节点；
 * 继续是123，k=3，k的变化是2->1->0，此时k=0，倒数第k个节点刚好是头节点；
 * 3、删除的节点存在，并且不是头节点；
 * 此时就需要好好讨论一下了：
 * 继续是123，k=2，k的变化是1->0->-1,此时k的值是-1;
 * 由此我们可以看出，当k=0的时候，遍历到的节点刚好就是要删除的那个节点，与删除节点的后一个节点链接然后返回头节点；
 * 此时就需要找到删除节点的前一个节点，
 * 可是如果遍历结束之后，k小于0呢？
 * 此时，应该重新从头节点开始走，每走一步，k加1，当k等于0的时候，
 * 移动停止，移动到的节点刚好就是要删除节点的前一个节点；
 * @date 2019/7/6 22:32
 */
public class RemoveLastKthNode {
    public static Node head = new Node(null);
    public static class Node{
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }
    public static void addNode1(Integer value){
        if (head.value == null){
            head.value = value;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
    public static Node removeLastKthNode(Integer k){
        Node head1 = head;
        while (head1 != null){
            k--;
            head1 = head1.next;
        }
        if (k > 0){
            return head;
        }else if (k == 0){
            return head.next;
        }else {
            //走到这一步，说明k已经小于0
            //此时就是要删除的倒数第K个节点在头节点后面
            //再次遍历链表,每移动一此，k++，直到k=0,停止
            Node tempHead = head;
            //注意此处要先进行k+1后再进入循环判断
            while (++k != 0){
                tempHead = tempHead.next;
            }
            tempHead.next = tempHead.next.next;
        }
        return head;
    }
    public static void printList(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        addNode1(5);
        addNode1(4);
        addNode1(3);
        addNode1(2);
        addNode1(1);

        printList(removeLastKthNode(5));

    }

}
