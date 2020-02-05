package dxc.no30_包含min函数的栈;

import java.util.Stack;

/**
 * @author dxc
 * @Title: ContainMinStack
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/3 20:38
 */
/*
* 要求，定义栈的数据结构，在该类型中实现一个能够得到栈的
* 最小元素的min函数，在该栈中，调用min、push以及pop的
* 时间复杂度都是O(1);
* */
public class ContainMinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;


    public ContainMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(Integer newItem){

        if (stackMin.isEmpty() || newItem < stackMin.peek()){
            stackMin.push(newItem);
        }
        stackData.push(newItem);
    }

    public void getMin(){
        if (!stackMin.isEmpty()){
            System.out.print(stackMin.peek());
        }else {
            System.out.println("栈已空！");
        }
    }

    public void pop(){

        if (stackData.isEmpty()){
            System.out.println("栈空了！");
            return;
        }
        //需要同时判断一下，弹出的话要判断一下两个栈顶元素的最小值是否相等；
        if (stackData.peek() <= stackMin.peek()){
            stackMin.pop();
        }
        stackData.pop();
    }
}
