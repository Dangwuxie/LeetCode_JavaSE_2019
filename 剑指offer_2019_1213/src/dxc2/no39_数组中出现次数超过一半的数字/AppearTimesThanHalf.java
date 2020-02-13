package dxc2.no39_数组中出现次数超过一半的数字;

import dxc2.RandomIndex;
import dxc2.Swap;

/**
 * @author dxc
 * @Title: AppearTimesThanHalf
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/10 21:31
 */
/*
* 题目要求：数组中出现次数超过一半的数字，找出来并且输出
* */
/*
* 思路：就是说，如果数组排序之后，那么这个数字在数组的中间，
* 也就是说排序之后位于数组中间的这个数肯定是要求的数字
* 就是中位数，
* 随机快排partition算法中，每排一次就会出现一个指定位置的数，如果这个位置
* 小于n/2,那么中位数就在它的右边部分，大于的话就在左边部分，如果刚好等于n/2,
* 呢吗此时的这个数就是所要求的数字
*
* 此处需要借助快速排序中的partition函数；
* 基于partition思想的O(N)的时间复杂度；
* */
public class AppearTimesThanHalf {

    public static int apperThanHalf(int[] arr){

        if (arr == null || arr.length == 0){
            return 0;
        }

        int middle = arr.length / 2;
        int left = 0;
        int right = arr.length-1;

        int res = partition(arr,left,right);

        while (res != middle){

            if (res > middle/2){
                //在右边部分
                right = res - 1;
                res = partition(arr,left,right);
            }else {
                left = res + 1;
                res = partition(arr,left,right);
            }

        }
        //当上面的while循环结束的时候，肯定有res=middle
        //就是说partition完了之后返回的结果下标就是middle坐标
        //此时需要判断一下数组中middle的这个数字出现次数是不是
        int result = arr[middle];

        if (!checkMoreThanHalf(arr,result)){
            System.out.println(checkMoreThanHalf(arr,result));
            result = 0;
        }
        return result;
    }

    /*
    * 快排partition函数
    * */
    private static int partition(int[] arr,int left,int right){
        //随机函数产生left-right之间的数字
        Swap.swap(arr,left,RandomIndex.randomIndex(left,right));

        int less = left - 1;
        int more = right;
        while (left < more){

            if (arr[left] < arr[right]){
                Swap.swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                Swap.swap(arr,--more,left);
            }else {
                //相等的情况
                left++;
            }
        }
        //more始终指向大于部分的第一个数字，
        //最后交换一下；返回more这个下标就行了
        Swap.swap(arr,more,right);

        return more;
    }



    private static boolean checkMoreThanHalf(int[] arr,int middle){
        //检查这个数是不是出现次数超过了一半；
        int times = 0;

        for (int i = 0;i < arr.length; i++){
            if (arr[i] == middle){
                times++;
            }
        }
        //<=说明不是正经数组
        return times > (arr.length/2);
    }
}
