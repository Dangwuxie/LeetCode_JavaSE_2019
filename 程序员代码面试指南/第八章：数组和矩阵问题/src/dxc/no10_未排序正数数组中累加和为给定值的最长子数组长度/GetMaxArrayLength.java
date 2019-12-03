package dxc.no10_未排序正数数组中累加和为给定值的最长子数组长度;

/**
 * @author 灵魂编程者
 * @Title: GetMaxArrayLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/3 22:17
 */

/*
* 1、题目要求：给定一个未排序的正数数组和一个k值，
* 需要在此数组中找到一个子数组满足子数组的累加和等于k，
* 求最长的子数组长度；
* */
/*
* 思路：给定的数组是正数，所以可以考虑可变滑动窗口，left和right两个指针，
* 从0下标处开始遍历，然后开始寻找最大数组；
* 注意：子数组必须是连成一篇的，并不是找最小的n个数来组成子数组；
* */
public class GetMaxArrayLength {

    public static int getMaxArrayLength(int[] array,int k){

        int left = 0;
        int right = 0;
        //len时刻记录最大的满足要求的子数组长度
        int maxLength = 0;
        //sum用来记录滑动窗口的和
        int sum = array[0];
        while (right < array.length){
            if (sum < k){
                right++;
                if (right == array.length){
                    break;
                }
                sum += array[right];
            }
            if (sum > k){
                sum -= array[left++];
            }
            if (sum == k){
                maxLength = (right-left+1) > maxLength ? (right-left+1) : maxLength;
                sum -= array[left++];
            }
        }
        return maxLength;
    }

}
