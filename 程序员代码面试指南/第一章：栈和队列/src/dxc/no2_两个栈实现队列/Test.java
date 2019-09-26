package dxc.no2_两个栈实现队列;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 15:18
 */
public class Test {
    public static void main(String[] args) {
        TwoStacksQueue stacksQueue =
                new TwoStacksQueue(new Stack<Integer>(),new Stack<Integer>());

        stacksQueue.add(1);
        stacksQueue.add(2);
        stacksQueue.add(3);
        System.out.println(stacksQueue.peek());
        System.out.println(stacksQueue.poll());
        System.out.println(stacksQueue.poll());
        stacksQueue.add(4);
        stacksQueue.add(5);
        System.out.println(stacksQueue.peek());
        System.out.println(stacksQueue.poll());

    }
}
