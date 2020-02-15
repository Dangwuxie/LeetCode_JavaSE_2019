package dxc3.no53_排序数组中查找数字;

/**
 * @author dxc
 * @Title: AppearTimesInOrder
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/13 12:19
 */
/*
* 题目要求：数字在排序数组中出现的次数,注意是排序数组
* */

public class AppearTimesInOrder {
    /*
    * 思路：首先这种思路是2*logN的思路；O(logN)时间复杂度
    * 利用二分查找思路，由于该数组是排序的，
    * 相同的数字是排列在一起的，找到第一个和最后一个就可以得出个数，
    * 每次递归的都是一半，所以套master公式就是LOG1 2的方式，最终时间复杂度就是OlogN
    * 比常规的O(N)的时间复杂度还小;
    * */
    public static int findNumberInOrder(int[] arr,int k){

        int res = 0;

        if (arr != null && arr.length != 0){

            int startIndex = getStart(arr,0,arr.length - 1,k);
            int endIndex = getEnd(arr,0,arr.length -1,k );

            if (startIndex > -1 && endIndex > -1){
                res = endIndex - startIndex + 1;
            }
        }

        return res;
    }

    /*
    * 二分法查找最左边的数字，就是起始点；
    * */
    private static int getStart(int[] arr,int left,int right,int k){

        if (left > right){
            return -1;
        }

        int midIndex = (right + left) / 2;
        int midData = arr[midIndex];

        if (midData == k){
            if (midIndex > 0 && arr[midIndex-1] != k || midIndex == 0){
                //判定条件就是如果当前下标处的数字刚好就是最左边的,
                //要么是整个数组第一个，要么就要判断前一个数字不等于k
                return midIndex;
            }else {
                //由于要找的是最左边的，所以一直往左边递归
                right = midIndex - 1;
            }
        }else if (midData < k){
            //去数组右边找
            left = midIndex + 1;
        }else {
            //去数组左边找起始点
            right = midIndex - 1;
        }

        return getStart(arr,left,right,k);
    }

    /*
    * 求右边的节点
    * */
    private static int getEnd(int[] arr,int left,int right,int k){

        if (left == right){
            return arr[left];
        }

        int midIndex = (right + left) / 2;
        int midData = arr[midIndex];

        if (midData == k){
            if (midIndex < arr.length -1 && arr[midIndex+1] != k || midIndex == arr.length - 1){
                //判定条件就是如果当前下标处的数字刚好就是最\右边的,
                //要么是整个数组最后一个，要么就要判断后一个数字不等于k
                return midIndex;
            }else {
                //由于要找的是最左边的，所以一直往左边递归
                left = midIndex + 1;
            }
        }else if (midData < k){
            //去数组右边找
            left = midIndex + 1;
        }else {
            //去数组左边找起始点
            right = midIndex - 1;
        }

        return getEnd(arr,left,right,k);
    }

}








