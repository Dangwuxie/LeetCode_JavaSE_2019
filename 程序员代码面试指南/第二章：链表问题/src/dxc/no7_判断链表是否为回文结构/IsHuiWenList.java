package dxc.no7_判断链表是否为回文结构;

import dxc.Node;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: IsHuiWenList
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/15 23:35
 */

/*
* 题目要求，给定一个链表的头节点，判断链表是否为回文结构
*
* */
public class IsHuiWenList {


    /*
    * 第一个方法，最简单的一种，利用栈结构实现，从head节点开始
    * 入栈，然后再出栈，跟原来的链表比较，如果反过来的链表有一个
    * 节点跟原始链表对不上号，那么就return false
    * */
    public static boolean isHuiWenList1(Node head){

        if (head == null || head.next == null){
            return true;
        }

        Stack<Node> stack = new Stack<Node>();
        Node cur = head;

        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    /*
    * 方法2：也是利用栈结构，不过入栈的元素只有链表的一般
    * 然后出栈跟链表的后半段比较。链表的节点个数如果是
    * 偶数，就直接对半分；如果是奇数，那就忽略最中间的那个节点；
    *
    * */
    public static boolean isHuiWenList2(Node head){

        if (head == null || head.next == null){
            return true;
        }

        Node right = head.next;
        Node cur = head;

        //找出链表后半部分的第一个节点，奇数偶数都可以
        while (cur.next != null && cur.next.next != null){
            cur = cur.next.next;
            right = right.next;
        }

        Stack<Node> stack = new Stack<Node>();
        //开始将后半部分的链表入栈
        while (right != null){
            stack.push(right);
            right = right.next;
        }

        //开始出栈，跟前半部分比较
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }

        return true;

    }
    /*
    *  方法3：不需要任何的数据结构，只用三个Node类型的变量，
    *  就可以判断链表的结构；
    *  实现思路：
    *  1、找到链表后半部分的第一个节点a，开始反转后半部分，
    *  这个节点a指向前一个节点，前一个节点b本来指向的是a，
    *  但是现在指向null；a指向b之前用节点c保存a.next,
    *  2、从head跟后半部分反转之后的最右边的节点，
    *  就是未反转之前的第一个节点，开始遍历并且比较，
    *  3、不论返回的是true还是false，都要还原链表；
    *
    *  总共就上面三步；
    * */
    public static boolean isHuiWenList3(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node a = head;
        Node b = head;
        Node c = null;//用来保存需要保存的关键性节点

        //寻找中间节点，和它的下一个节点(链表后半部分的第一个节点)
        //while循环结束后的b节点刚好就是中间节点，
        //它的下一个节点刚好就是后半部分的第一个节点
        while (a.next != null && a.next.next != null){
            a = a.next.next;
            b = b.next;
        }
        //c是后半部第一个节点
        c = b.next;
        b.next = null;
        //开始反转链表
        while (c!=null){
            a = c.next;
            c.next = b;
            b = c;
            c = a;
        }
        //此时，b就是最右边的节点
        //开始和head节点开始遍历并且比较
        //这里需要保存一下最右边的节点一次；
        c = b;
        a = head;
        boolean res = true;
        //检查是不是回文结构
        while (a != null && b != null){
            if (a.value != b.value){
                res = false;
            }
            a = a.next;
            b = b.next;
        }

        //下面就是恢复链表了
        b = c.next;
        c.next = null;

        while (b != null){
            a = b.next;
            b.next = c;
            c = b;
            b = a;
        }

        return res;
    }
}
