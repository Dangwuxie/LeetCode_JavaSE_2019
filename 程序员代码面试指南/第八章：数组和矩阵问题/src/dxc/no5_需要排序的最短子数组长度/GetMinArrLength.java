package dxc.no5_需要排序的最短子数组长度;

import java.util.concurrent.AbstractExecutorService;

/**
 * @author 灵魂编程者
 * @Title: GetMinArrLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/27 22:39
 */

/*
* 思路很明确，
* 从右向左遍历，用Min记录出现过的最小值，如，如果碰到arr[i]>min,minIndex=i;
* minIndex始终指向最左边出现这种情况出现的位置，出现这种情况就意味着需要交换元素重新排序
*
* 然后从左向右遍历，用max记录当前的最大数字，如果出现arr[i]<max,maxIndex=i;
* 记录最右边出现这种情况的位置，
*
* 最后返回maxIndex-minIndex+1;就是要交换的元素个数，即最小子数组
*
* */
public class GetMinArrLength {

    public static int getMinArrLength(int[] arr){

        if (arr == null || arr.length<2){
            return 0;
        }

        int minIndex = -1;
        int min = arr[arr.length-1];

        for (int i=arr.length-2;i>=0;i--){
            //判断有没有需要交换的元素
            if (arr[i]>min){
                minIndex = i;
            }else {
                //始终保持min是从右到左的最小的元素
                min = Math.min(arr[i],min);
            }
        }

        if (minIndex == -1){
            return 0;
        }

        int max = arr[0];
        int maxIndex = -1;

        for (int j=1;j<arr.length;j++){
            if (arr[j]<max){
                maxIndex = j;
            }else {
                max = Math.max(max,arr[j]);
            }
        }

        return maxIndex-minIndex+1;

    }
}
