import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Dangxuchao
 * @Title: LinkedListMyQUeue
 * @ProjectName leetcode_栈和队列笔试题
 * @Description: 利用LinkedList实现用栈表示队列；
 * @date 2019/6/11 16:32
 */
public class LinkedListMyQUeue {
    private LinkedList<Integer> stack ;
    /** Initialize your data structure here. */
    public LinkedListMyQUeue() {
        this.stack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.addFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
