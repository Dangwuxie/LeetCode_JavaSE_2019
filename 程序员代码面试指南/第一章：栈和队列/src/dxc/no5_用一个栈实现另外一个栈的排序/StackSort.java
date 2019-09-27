package dxc.no5_用一个栈实现另外一个栈的排序;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: StackSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/27 20:14
 */

/*
* 题目要求，只能利用一个栈来对传入进来的栈进行排序
* 不能多定义其他的数据结构：
*
* 思路，定义一个help栈，每次从stack中弹出一个元素与help的栈顶元素cur作比较
* 我们需要实现的就是help的元素从栈顶到栈底的顺序是按照从小到大的顺序排的，
* 所以当cur比help的栈顶元素大或者等于时，help弹出到stack中，
* 一直到cur小于当前help的栈顶元素，然后压入cur到helop中去
* */
public class StackSort {
    public static void stackSort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            Integer cur = stack.pop();
            while (!help.isEmpty()&&cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //完了之后，说明stack中已经没有元素了
        //help中已经排好序
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }


}
