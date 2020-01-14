package dxc.no9_栈和队列相互实现;

import java.util.Stack;

/**
 * @author dxc
 * @Title: StackToQueue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/13 16:00
 */
/*
* 题目要求，利用两个栈实现队列;
*
* */
public class StackToQueue {
    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    public static void deleteHead(){
        if (!s2.isEmpty()){
            System.out.println("删除-"+s2.peek());
            s2.pop();
        }else if (!s1.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            System.out.println("删除-"+s2.peek());
            s2.pop();
        }else {
            System.out.println("当前队列已经没有元素了！！");
        }
    }

    public static void appendTail(int val){
        s1.push(val);
    }

    public static void printQueue(){

        while (!s2.isEmpty()){
            System.out.println(s2.pop());
        }

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        while (!s2.isEmpty()){
            System.out.println(s2.pop());
        }

        if (s2.isEmpty()){
            System.out.println("队列已经空了！！");
        }
    }
}
