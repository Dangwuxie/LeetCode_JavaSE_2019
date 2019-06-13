import java.util.Stack;

/**
 * @author Dangxuchao
 * @Title: MinStack
 * @ProjectName leetcode_栈和队列笔试题
 * @Description: 题目：最小栈的实现
 * 实现一个栈，该栈带有出栈(pop) 入栈(push)  取最小值(getMin)3个方法，
 * 要保证这三个方法的时间复杂度都是O(1);最坏情况空间复杂度时O(n)；
 *
 *解题思路：用两个栈A/B实现，
 * A为主栈，一直存入栈元素，B为辅助栈，一直存A栈当前的最小元素
 * 也就是说，栈B的栈顶元素一直都是栈A的最小元素；
 * @date 2019/6/13 18:17
 */
public class MinStack {
    //先写两个栈
    private static Stack<Integer> stackA = new Stack<Integer>();
    private static Stack<Integer> stackB = new Stack<Integer>();

    public static void push(Integer e){
        if (stackA.isEmpty() && stackB.isEmpty()){
            stackA.push(e);
            stackB.push(e);
        }else {
            stackA.push(e);
            if (e < stackB.peek()){
                stackB.push(e);
            }
        }
    }

    public static Integer pop(){
        if (stackB.peek().equals(stackA.peek())){
            stackB.pop();
        }
        return stackA.pop();
    }

    public static Integer getMin(){
        if (stackB.isEmpty()){
            try {
                throw new Exception("栈已空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stackB.peek();
    }
}
