package dxc.no8_单调栈结构;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: MinIndex2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/29 23:45
 */
/*
* 利用栈实现此方法，时间复杂度为O(N^2)，
* 单调栈的实现：O(N)的时间复杂度
*
* 思路：使用栈，栈中存放的就是数组的下标，然后呢，
* 从0下标开始遍历数组，如果要找左边和右边离的最近的小于当前位置的值的位置，
* 需要栈从栈顶到栈底的下标代表的元素是严格递减的，如果当前的下标元素比栈顶下标元素大
* 就压入栈，否则弹出，此时弹出的这个就是二维数组中要保存的数组的横坐标，
* 然后这个弹出的元素的下一个栈中下标就是它左边的最近最小值，
* 当前遍历的就是右边的最小最近值。
* 这种做法的前提是栈是个单调递增的栈，每次压入的元素比当前的栈顶元素要大
*
* 如果是要找两边第一个max的元素，这个栈可以是单调递减的
*
* */
public class MinIndex2 {

    public static int[][] findMinIndex(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        //下面遍历数组
        for (int i=0;i<arr.length;i++){

            //如果栈不为空，测试需要判断i元素与栈顶元素的大小关系
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                //如果弹出元素了，就需要在res中记录了
                int cur = stack.pop();
                //下一个栈顶元素就是左边的小于它的最近的
                //当前遍历的i元素就是右边的最近的
                //这里需要判断临界值，最后一个栈元素弹出后，左边已经没有下标了
                //说明在数组对应下标处左边没有比它小的或者已经没有元素了
                res[cur][0] = stack.isEmpty()?-1:stack.peek();
                res[cur][1] = i;
            }
            stack.push(i);
        }

        //此时栈中元素肯定还没有弹出完毕，前面我们入栈的时候
        //就是按照从小到达的顺序入栈的，所以此时直接出栈，
        //此时可以发现，剩下的index对应的数组里面，
        //右边已经不存在比它小的数了，所以直接记录res[i][0]就行
        while (!stack.isEmpty()){
            int cur = stack.pop();
            res[cur][0] = stack.isEmpty()?-1:stack.peek();
            res[cur][1] = -1;
        }
        return res;
    }
}














