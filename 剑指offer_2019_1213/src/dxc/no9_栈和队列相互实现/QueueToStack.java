package dxc.no9_栈和队列相互实现;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dxc
 * @Title: QueueToStack
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/13 16:00
 */
public class QueueToStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueToStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int val){
        //每次保证有一个队列是空的
        //非空的那个队列一直保持的入栈的顺序
        if (q1.isEmpty() && q2.isEmpty()){
            q1.offer(val);
        }else if (q1.isEmpty() && !q2.isEmpty()){
            q1.offer(val);
            while (!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }else if (!q1.isEmpty() && q2.isEmpty()){
            q2.offer(val);
            while (!q1.isEmpty()){
                q2.offer(q1.poll());
            }
        }

    }

    public void pop(){
        if (!q1.isEmpty() && q2.isEmpty()){
            System.out.println(q1.peek());
            q1.poll();
        }else if (q1.isEmpty() && !q2.isEmpty()){
            System.out.println(q2.peek());
            q2.poll();
        }else if (q1.isEmpty() && q2.isEmpty()){
            System.out.println("队列已经空了！！！");
        }
    }

    public boolean empty(){
        return q1.isEmpty() && q2.isEmpty();
    }
}
