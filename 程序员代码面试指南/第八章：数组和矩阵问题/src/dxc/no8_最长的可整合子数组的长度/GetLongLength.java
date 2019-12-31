package dxc.no8_最长的可整合子数组的长度;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dxc
 * @Title: GetLongLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/31 22:07
 */
/*
* 题目要求：给定一个数组，返回该数组的最长可整合子数组的长度
* 可整合数组的定义，比如排序完成后每相邻的元素之间的差为1；
* 比如[5,2,3,4,6],排序之后就是一个可整合数组,[2,3,4,5,6];
* */
public class GetLongLength {
    /*
    * 思路1，需要额外一个数组，每次保存原数组中的i--j之间的元素来判断是不是可整合数组
    * 首先，每次获取子数组的时间复杂度就是O(N2),然后给子数组进行排序，又是时间复杂度为O(NlogN),
    * 所以整体复杂度就是O(N3 log N);
    *
    * */
    public static int getLongLength(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int maxLen = 0;

        for (int i = 0;i < arr.length; i++){

            for (int j = i;j < arr.length; j++){
                if (checkArr(arr,i,j)){
                    maxLen = (j - i + 1) < maxLen ? maxLen : (j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private static boolean checkArr(int[] arr,int left,int right){

        int[] arr2 = Arrays.copyOfRange(arr,left,right+1);//此函数截取是左闭右开
        for (int i = 1;i < arr2.length; i++){
            if (arr2[i-1] != arr2[i]-1){
                return false;
            }
        }
        return true;
    }

    /*
    * 思路2：可以这样想，如果某一个子数组里面的数字不重复，而且依次递增1，
    * 那么这个子数组中的最大数max和最小数min的差再加1，就是这个子数组的长度
    * 比如[5,3,1,2,4],是个可整合数组，然后5-1=4；4+1=5；就是这个数组的长度；
    * 相对于上面的思路，时间复杂度，判断是不是可整合子数组的复杂度就变成了O(1)
    * 最终的时间复杂度就是O(N2);
    * */
    public static int getLongLength2(int[] arr){
        int maxLen = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0;i < arr.length; i++){
            max = Integer.MIN_VALUE;//max从最小值开始
            min = Integer.MAX_VALUE;//min从最大值开始

            for (int j = i;j < arr.length; j++){
                if (set.contains(arr[j])){
                    //如果出现重复数组，之间break当前的循环
                    break;
                }
                //set如果不包含当前的这个元素，就需要添加进入，以便于后面判断
                set.add(arr[j]);
                //否则就获取当前的最大值和最小值，后面将要使用
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);

                if (max-min == j-i){    //等同于(max-min+1) == (j-i+1)
                    maxLen = maxLen > (j-i+1) ? maxLen : (j-i+1);
                }
            }

            set.clear();
        }

        return maxLen;
    }

}
