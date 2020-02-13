package dxc2.no40_最小的k个数;

import static dxc2.Swap.swap;

/**
 * @author dxc
 * @Title: TheLastKNumbers
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/11 18:48
 */
/*
* 题目要求：给定一个无序数组，求出最小的k个数，k可以自定义；
* 思路1：维持一个堆，数组实现，大小为k，始终存储着当前数组的k个最小数；
* 思路2：利用partition的思想，分区之后如果当前的这个数字刚好就是第k-1个数字
*       那么此时返回这个数字的下标，前面的数字就是最小的k个数；
*
*       O(N)的时间复杂度
* */
public class TheLastKNumbers {

    public static void theLastKNumbers(int[] arr,int k){

        if (arr == null || arr.length == 0 || k > arr.length - 1){
            System.out.println("输入数组 错误！");
            return;
        }

        int right = arr.length - 1;
        int left = 0;
        int index = partition(arr,left,right);

        while (index != k - 1){

            if (index < k-1){
                left = index + 1;
                index = partition(arr,left,right);
            }else {
                right = index - 1;
                index = partition(arr,left,right);
            }
        }
        int i = 0;
        while (i < k){
            System.out.print(arr[i] + "-");
            i++;
        }

    }

    private static int partition(int[] arr,int left,int right){

        int less = left - 1;
        int more = right;
        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                swap(arr,--more,left);
            }else {
                left++;
            }
        }
        swap(arr,more,right);

        return more;
    }

}
