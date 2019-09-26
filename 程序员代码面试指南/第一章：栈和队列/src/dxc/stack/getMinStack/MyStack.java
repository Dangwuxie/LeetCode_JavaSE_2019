package dxc.stack.getMinStack;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: MyStack
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/8 23:39
 */

/*
* 设计一个有getMin功能的栈，在实现栈基本功能的基础上，再实现返回栈中最小值的操作
* pop、push、getmin操作的时间复杂度都是O(1)
*思路：使用两个栈，一个保存正常存放的栈stackdata，一个保存当前栈中的最小元素stackmin
* 就是说这个stackmin的栈顶元素一致都是当前stackdata的最小的元素
* */
public class MyStack {
    private Stack<Integer> stackdata ;
    private Stack<Integer> stackmin ;

    public MyStack() {
        this.stackdata = new Stack<>();
        this.stackmin = new Stack<>();
    }

    public void push(int newItem){
        /*
        * 入栈的时候要注意，先判断此时要入栈的元素是不是比当前stackmin的栈顶元素小，
        * 如果小，两个栈都要入，否则只进入stcakdata栈；第一次要判断stackmin栈为空
        * */
        if (this.stackmin.isEmpty() || newItem < this.stackmin.peek()){
            this.stackmin.push(newItem);
        }
        //此时给stackdatapush数据
        this.stackdata.push(newItem);
    }

    public void pop(){
        /*
        * 注意，pop弹出元素的时候，需要判断此时stackdata的栈顶元素
        * 跟stackmin的栈顶元素是否相等
        * 或者小于，如果是，两个栈同时弹出，否则只有stackdata弹出元素
        * */
        if (this.stackdata.isEmpty()){
            throw new RuntimeException("stackdata is Empty!!");
        }
        if (this.stackdata.peek() <= this.stackmin.peek()){
           this.stackmin.pop();
        }
        this.stackdata.pop();
    }

    public Integer getMin(){
        //stackmin的栈顶元素一直都是当前stackdata的最小元素
        return stackmin.peek();
    }

}
