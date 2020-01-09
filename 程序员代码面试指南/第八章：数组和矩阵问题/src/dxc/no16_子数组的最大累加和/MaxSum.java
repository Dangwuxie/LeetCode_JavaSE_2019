package dxc.no16_子数组的最大累加和;

/**
 * @author dxc
 * @Title: MaxSum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/9 21:55
 */

/*
* 题目要求：给定一个数组，数组中有正负数，
* 求所有的子数组中累加和最大的子数组的和是多少？
* 比如[1,-2,3,5,-2,6,-1]
* 最大为[3,5,-2,6]，和为12;
* 要求时间复杂度为O(N),额外空间复杂度为O(1);
* */
public class MaxSum {
    /*
    * 思路：可以这样想，因为从数组第一个元素开始往后一直累加
    * 用一个变量maxSum一直记录累加的最大值，当从开始累加到某个位置的时候
    * 如果累加和变为负数，那么这一部分相对于后面的累加是没有任何作用的
    * 只会起到减的作用，所以从当前位置的下一个位置重新开始累加计数
    * 重新开始记录maxSum。
    * */
    /*
    * 意思就是：当累加和小于0的时候，那么累加的这一部分肯定
    * 不能作为最大累加和的子数组的左边部分。
    * */
    public static int maxSum(int[] arr){

        if (arr == null || arr.length == 0){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;//从最小的值开始记录起
        int tempSum = 0;

        for (int i = 0;i < arr.length; i++){
            tempSum += arr[i];
            maxSum = Math.max(maxSum,tempSum);
            tempSum = tempSum < 0 ? 0 : tempSum;
        }

        return maxSum;
    }
}
