package dxc;

/**
 * @author 灵魂编程者
 * @Title: PrintLinkedList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/22 23:31
 */
public class PrintLinkedList {

    public static void printLinkedList(Node head){
        if (head == null){
            return;
        }
        Node temp = head;

        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
