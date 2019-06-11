import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dangxuchao
 * @Title: MyStack
 * @ProjectName leetcode_栈和队列笔试题
 * @Description: 用队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2019/6/11 13:56
 */
public class MyStack {
    public Queue<Integer> queue1 ;
    public Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    /**
     * 入栈是关键，因为内部是两个队列实现的
     * 每次stack.pop的时候，返回的一定要是最后一个入栈的
     * 就是说要输出队列的最后一个元素
     * 所以每次push操作都要保证非空的queue第一个元素就是当前push进来的元素
     */
    /** Push element x onto stack. */
    public void push(int x) {

        if (queue1.isEmpty()&&queue2.isEmpty()){
            queue1.offer(x);
        }
        else if (queue1.isEmpty()&&!queue2.isEmpty()){
            queue1.offer(x);
            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
        }else if (!queue1.isEmpty()&&queue2.isEmpty()){
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()){
            return queue1.poll();
        }
        if (!queue2.isEmpty()){
            return queue2.poll();
        }
        if (queue1.isEmpty()&&queue2.isEmpty()){
            throw new EmptyStackException();
        }
        return 0;
    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()){
            return queue1.peek();
        }
        if (!queue2.isEmpty()){
            return queue2.peek();
        }
        if (queue1.isEmpty()&& queue2.isEmpty()){
            throw new EmptyStackException();
        }
        return 0;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
