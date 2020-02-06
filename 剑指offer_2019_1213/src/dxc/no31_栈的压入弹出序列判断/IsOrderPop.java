package dxc.no31_栈的压入弹出序列判断;


import java.util.Stack;

/**
 * @author dxc
 * @Title: IsOrderPop
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/4 17:40
 */
/*
* 题目要求，给定两个数字序列，前者为入栈序列，
* 判断后者是否是前者的出栈序列
* */
public class IsOrderPop {

    public static boolean isOrderPop(String pushArr,String popArr){

        char[] push = pushArr.toCharArray();
        char[] pop = popArr.toCharArray();
        Stack<Character> stack = new Stack<>();

        int pushCur = 0;
        int popCur = 0;

        while (popCur < pop.length){

            while (stack.isEmpty() || stack.peek() != pop[popCur]){

                if (pushCur == push.length){
                    break;
                }

                stack.push(push[pushCur]);
                pushCur++;
            }

            if (stack.peek() != pop[popCur]){
                break;
            }

            stack.pop();
            popCur++;
        }

        if (popCur == pop.length){
            return true;
        }

        return false;
    }
}
