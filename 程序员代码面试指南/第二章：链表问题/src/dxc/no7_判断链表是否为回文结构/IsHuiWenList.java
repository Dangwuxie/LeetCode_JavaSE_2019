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
public class IsHuiWenList {

    public boolean isHuiWenList(Node head){

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

}
