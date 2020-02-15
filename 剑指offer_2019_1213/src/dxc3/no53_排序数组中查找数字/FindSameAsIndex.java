package dxc3.no53_排序数组中查找数字;

/**
 * @author dxc
 * @Title: FindSameAsIndex
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/14 15:22
 */
/*
* 题目要求：递增的数组，正负都有，找出任意一个数值等于其下标的元素;
* 暴力遍历法：O(N)的时间复杂度
* 思路：二分查找O(logN)的时间复杂度；
* */
public class FindSameAsIndex {
    /*
    * 注意，每次找中间坐标出的数值，
    * 如果这个数值比坐标大，那么就直接去mid左边去找，因为往后的都会比坐标大
    * 如果这个数值比坐标小，那么就直接去右边找，因为左边的数值会一直比坐标大；
    * */
    public static int findSameAsIndex(int[] arr){

        if (arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){

            int middleIndex = (left + right) >> 1;
            if (arr[middleIndex] == middleIndex){
                return middleIndex;
            }else if (arr[middleIndex] > middleIndex){
                right = middleIndex - 1;
            }else {
                left = middleIndex + 1;
            }
        }

        return -1;
    }
}





