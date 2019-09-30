package dxc.no8_单调栈结构;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: MinIndex3
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/30 16:25
 */

/*
* 当传入的数组中存在重复的值的时候：
* 此时需要使用List来保存相同的数，所以此时栈中保存的也就是List；
* List<Integer>
*
* */
public class MinIndex3 {

    public static int[][] findMinIndex(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();

        for (int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek().get(0)]>arr[i]){

                List<Integer> popList = stack.pop();
                int leftIndex = 0;
                if (stack.isEmpty()){
                    leftIndex = -1;
                }else {
                    leftIndex = stack.peek().get(stack.peek().size()-1);
                }
                //list中可能存在多个相同的值，所以此时它们的左边的min是同一个
                for (Integer o:popList){
                    //注意，此时如果栈不为空，那么res对应的[o][0]的值就是
                    // 当前弹出的list的下一个栈中元素最后一个元素
                    //也就是说是最后一个添加的元素
                    res[o][0] = leftIndex;
                    res[o][1] = i;
                }
            }

            //此为入栈,
            if (!stack.isEmpty() && arr[stack.peek().get(0)]==arr[i]){
                //如果当前要入栈的元素跟栈顶元素相同
                stack.peek().add(i);
            }else {
                //如果不相同，就要入栈，因为上面已经排除了大于栈顶元素的可能
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }

        }

        //此时已经遍历完数组，就是开始取出栈中剩下的元素了
        while (!stack.isEmpty()){
            List<Integer> popList = stack.pop();
            for (Integer o:popList){
                res[o][0] = stack.isEmpty() ? -1:stack.peek().get(stack.peek().size()-1);
                res[o][1] = -1;
            }
        }
        return res;
    }
}









