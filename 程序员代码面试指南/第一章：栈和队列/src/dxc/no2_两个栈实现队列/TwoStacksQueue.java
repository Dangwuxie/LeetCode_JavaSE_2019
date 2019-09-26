package dxc.no2_两个栈实现队列;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: TwoStacksQueue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 15:19
 */

/*
* 两个栈实现一个队列，支持基本的add，poll，peek
* 思路：
* 使用stackpush和stackpop两个栈，push栈负责压入元素，
* 然后一次性弹出当前栈中元素到pop栈中取，然后由pop栈弹出元素，作为队列的poll方法
* 注意：pop栈不为空时不可压入新的元素，如果要将push栈中的元素
* 压入pop中，必须一次性压入；
* */
public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    //
    public void add(Integer value){
        stackPush.push(value);

    }

    private void pushToPop(){
        if (stackPop.isEmpty()&&!stackPush.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }else {
            System.out.println("Queue is Empty！");
        }
    }

    public int poll(){
        if (!stackPop.isEmpty()){
            return stackPop.pop();
        }else {
            //此时stackPop就是空的，需要往里面压值
            pushToPop();
        }
        return stackPop.pop();
    }

    public int peek(){
        if (!stackPop.isEmpty()){
            return stackPop.peek();
        }else {
            //此时stackPop就是空的，需要往里面压值
            pushToPop();
        }
        return stackPop.peek();
    }
}
