package dxc3.no59_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author dxc
 * @Title: MaxInWindows
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/23 11:10
 */
/*
* 题目：滑动窗口的最大值；
* 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值
* 比如，输入数组{2,3,4,2,6,2,5,2};
* 最大值为{4,4,6,6,6,5};
* */
/*
* 解题思路：双端队列存储数组元素的下标，对头一直是当前滑动窗口的最大值得下标
* 每次窗口移动，就要判断，如果当前最右得下标和当前的队列最大元素下标的差大于或者等于k
* 那么此时队头元素就要出队；如果当前的元素比队尾下标表示的元素大，那么此时
* 队尾出队，因为这个元素不会是当前窗口的最大值的；
* */
public class MaxInWindows {

    public static void maxInWindows(int[] arr,int k){

        if (arr == null|| arr.length == 0 || k < 1){
            return;
        }

        //队头始终是目前窗口的最大值的下标
        Deque<Integer> maxIndex = new LinkedList<>();

        int right = 0;
        maxIndex.add(right);
        while (right < arr.length){

            while (!maxIndex.isEmpty() && (right - maxIndex.peekFirst() >= k)){
                maxIndex.poll();
            }
            while (!maxIndex.isEmpty() && arr[right] > arr[maxIndex.peekLast()]){
                maxIndex.pollLast();
            }
            maxIndex.add(right);
            if (right > 1){
                System.out.print(arr[maxIndex.peekFirst()]+"--");
            }
            right++;
        }
        /*
        * 4--4--6--6--6--5--
        * */
    }


}







