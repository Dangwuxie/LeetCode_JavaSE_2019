/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName leetcode_栈和队列笔试题
 * @Description: 测试最小栈的实现
 * @date 2019/6/13 18:27
 */
public class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(7);
        minStack.push(4);
        minStack.push(8);
        minStack.push(2);
        minStack.push(10);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        /*
        运行结果
                    2
                    2
                    4
                    4
                    5
         */
    }
}
