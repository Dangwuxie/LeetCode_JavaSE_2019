package dxc.no7_生成窗口最大值数组;

import java.util.LinkedList;

/**
 * @author 灵魂编程者
 * @Title: GetMaxWindow
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/28 15:48
 */
/*
 * 题目要求，给个数组arr和大小为w的窗口，然后窗口从左向右滑动，每次滑动一格
 * 求出滑动完后每一次滑动后的窗口最大值
 *
 * 思路：可以利用双端队列实现，每次从队列的尾部插入元素，然后从队列头部出队元素
 * 注意，对头元素始终是当前队列中最大元素的下标，
 * 每次遍历一个元素都需要判断队列头部元素是不是已经离队
 * 就是说队列头部的元素是不是已经不在窗口里面
 *
 * 遍历下来后，arr中可以获得的最大值元素的值一共arr.length-1+w个
 * 所以res的数组的小就是这个
 * */
public class GetMaxWindow {
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w<1 || arr.length<w){
            return null;
        }

        //创建一个双端队列q
        LinkedList<Integer> qmax = new LinkedList<>();
        //用于存储每一步当前窗口的最大值
        int[] res = new int[arr.length-w+1];

        int index = 0;

        for (int i=0;i<arr.length;i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                //弹出队列最后一个元素
                qmax.pollLast();
            }
            //压入下标
            qmax.addLast(i);
            //判断当前的窗口队头元素是否已经过期
            if (qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            //必须从第w个元素开始才算一个窗口
            if (i >= w-1){
                //保存当前的队头元素，队头元素一直是当前窗口的最大元素
                res[index++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }

}
