package dxc3.no53_排序数组中查找数字;

/**
 * @author dxc
 * @Title: FindSingleInOrderArr
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/14 14:17
 */
/*
* 题目要求，长度为n-1的递增排序数组中的数字都是唯一的，每个数字范围都在0-n-1之中
* 在0-n-1的范围内的n个数字，只有一个数字不在该数组内，请找出这个数字；
* */
public class FindSingleInOrderArr {
    /*
    * 注意是递增数组
    * 思路1，先求出0-n-1个数字的和，然后在计算数组的和，相减的差就是要求的那个数字
    * 但是时间复杂度上为O(N);
    * 思路2：二分查找的思路，题目所说，那么这个数组中从这个数开始往后所有数字的下标
    * 应该都是本身+1；这个数前面的数字跟本身下标是相同的；
    * 所以直接找第一个下标跟本身不一样的数字就行了
    * */

    public static int findNumber(int[] arr,int length){

        if (arr == null || arr.length == 0){
            return -1;
        }

        int left = 0;
        int right = length - 1;

        while (left <= right){

            int middle = (left + right) >> 1;
            if (arr[middle] != middle){

                if (middle == 0 || arr[middle-1] == middle-1){
                    //如果是第一个，或者前一个的数字和下标是相等的
                    return middle;
                }else {
                    //如果前一个也跟下标不相等，那么递归左边的
                    right = middle - 1;
                }
            }else {
                //直接去左半区查找
                left = middle + 1;
            }
        }
        /*
        * 注意，有一种情况，就是所有数都与下标相等，
        * */
        if (left == length){
            return length;
        }
        //如果前面的都没有返回所求值，那么此时返回-1；
        //比如无效的输入，数组没有按照要求排序，或者有数字不在0-n-1内
        return -1;

    }
}






