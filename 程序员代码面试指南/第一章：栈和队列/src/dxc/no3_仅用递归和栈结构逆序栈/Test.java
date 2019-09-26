package dxc.no3_仅用递归和栈结构逆序栈;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 16:25
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        ReverseStack.reverse(stack);
        System.out.println(stack);
    }
}
