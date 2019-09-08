package com.dxc.stack.getMinStack;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/8 23:39
 */
/*
*
*
* */
public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(1);
        myStack.push(7);

        System.out.println(myStack.getMin());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.getMin());
    }
}
