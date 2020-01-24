package dxc;

/**
 * @author dxc
 * @Title: PrintList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/23 23:18
 */
public class PrintList {

    public static void printList(Node head){
        if (head == null){
            System.out.println("链表为空！！！");
        }
        while (head != null){
            System.out.print(head.value+"-");
            head = head.next;
        }
    }
}
