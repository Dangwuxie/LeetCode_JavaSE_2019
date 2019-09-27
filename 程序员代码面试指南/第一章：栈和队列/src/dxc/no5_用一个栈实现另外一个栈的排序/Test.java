package dxc.no5_用一个栈实现另外一个栈的排序;

import dxc.StackPrint;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/27 20:14
 */
public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(9);

        StackSort.stackSort(stack);
        StackPrint.printStack(stack);
    }
}
