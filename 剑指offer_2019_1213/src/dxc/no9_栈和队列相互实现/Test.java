package dxc.no9_栈和队列相互实现;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/13 16:00
 */
public class Test {

    public static void main(String[] args) {

        QueueToStack queue = new QueueToStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        queue.pop();
        queue.pop();
        /*StackToQueue.appendTail(1);
        StackToQueue.appendTail(2);
        StackToQueue.appendTail(3);
        StackToQueue.appendTail(4);
        StackToQueue.deleteHead();
        StackToQueue.appendTail(5);

        StackToQueue.deleteHead();
        StackToQueue.deleteHead();
        StackToQueue.deleteHead();
        StackToQueue.deleteHead();
        StackToQueue.deleteHead();

        StackToQueue.printQueue();*/


    }
}
