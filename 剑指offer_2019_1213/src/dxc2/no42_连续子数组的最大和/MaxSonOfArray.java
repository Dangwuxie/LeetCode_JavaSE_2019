package dxc2.no42_连续子数组的最大和;

/**
 * @author dxc
 * @Title: MaxSonOfArray
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/14 21:12
 */
/*
* 题目要求：输入一个整形数组，数组里面有正数也有负数。
* 数组中一个或者多个都可以组成子数组；有n*(n+1)/2个子数组；
* 求子数组中和最大的值，要求时间复杂度为O(N);
* */
public class MaxSonOfArray {

    public static int maxSonOfArray(int[] arr){

        if (arr == null || arr.length == 0){
            return 0;
        }

        int sum = 0;
        int max = 0;

        for (int i = 0;i < arr.length; i++){

              sum += arr[i];
              if (sum <= 0){
                  sum = 0;
              }
              max = sum > max ? sum : max;
        }

        return max;
    }
}









