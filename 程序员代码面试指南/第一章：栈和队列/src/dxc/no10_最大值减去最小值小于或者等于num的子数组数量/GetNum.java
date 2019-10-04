package dxc.no10_最大值减去最小值小于或者等于num的子数组数量;

import java.util.LinkedList;

/**
 * @author 灵魂编程者
 * @Title: GetNum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/4 14:34
 */
/*
* 题目要求：给定一个数组和一个整数num，求多少个子数组满足：子数组中的最大值减去最小值小于等于num的情况
* //首先请解决前面的窗口最大值问题；
*
*
*
* */
public class GetNum {

    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0 || num < 0){
            return 0;
        }
        //双端队列保存维持当前子数组最大值信息
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i=0;
        int j=0;
        int res = 0;

        while (i<arr.length){

            while (j<arr.length){
                if(qmin.isEmpty() || qmin.peekLast()!=j){//为什么要判断这一句？

                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                        //qmin队列保持元素对应的数组元素递增
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                        //保持最大值递减
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }

                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()]>num){
                    break;
                }

                j++;
            }
            res += j-i;
            //当下次j进入循环的时候，就是上次j停止的时候的值

            //两个if语句判断当前队列首部元素是否过期
            if (qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }

            i++;
            //注意，当窗口向右滑动一下，i+1到当前的j位置，依旧是满足最大值减去最小值小于等于num的，
            //下一次循环进来后，j直接向后继续遍历，知道满足停止条件，然后再次计算res += j-i
            // 就是在计算以前一个i+1开始的所有满足条件的子数组;
            //当j遍历到arr.length的时候，内层循环就不用进去了，每次就是i++，然后计算i开始的子数组个数
            //因为这个范围内的子数组都满足条件；
        }

        return res;
    }

}
