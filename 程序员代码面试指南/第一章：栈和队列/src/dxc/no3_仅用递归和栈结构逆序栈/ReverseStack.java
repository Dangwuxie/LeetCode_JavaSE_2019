package dxc.no3_仅用递归和栈结构逆序栈;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: ReverseStack
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 16:39
 */

/*
* 仅仅使用递归和栈结构，逆序一个栈
* 思路：
* 首先，需要每次获取一个栈的栈底元素，获取后将剩下的元素反转，
* 然后压入这个元素，此时这个元素就在当前的栈顶；剩下的元素通过递归实现
* 可以是N-1,N-2,N-3...递归到最后当前栈中只存在一个元素，把这个元素"反转"
* 压入栈底，然后将当前pop出来的栈底元素push进去；
*
* 举个例子：123，从栈底开始获取，顺序为1，2，3
* 到3的时候栈为空，所以就反着压入，从栈底开始为3，2，1；
*
*   1、递归获取并移除栈底元素
*   2、取得当前占地元素后递归反转当前的栈
* */
public class ReverseStack {
    //首先写一个可以获得并且移除当前栈底元素的方法
    public static Integer getAndRemoveLastStack(Stack<Integer> stack){
        Integer res = stack.pop();
        if (stack.isEmpty()){
            return res;
        }else {
            //如果当前栈不为空，递归调用此方法获取栈底元素
            Integer last = getAndRemoveLastStack(stack);
            stack.push(res);
            //最后返回
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        //每次获取并且移除当前栈底元素
        Integer i = getAndRemoveLastStack(stack);
        //继续递归反转剩下的栈元素
        reverse(stack);
        stack.push(i);
    }
}
