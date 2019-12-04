package dxc.no11_未排序数组中累加和为给定值的最长子数组系列问题;

import java.util.HashMap;

/**
 * @author 灵魂编程者
 * @Title: GetMaxArrayLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/4 17:00
 */
/*
*1、题目要求：给定你一个为排序数组，里面的数可以是负数正数和0三种，
* 求累加和为给定值得最长子数组得长度；
*
* */

/*
* 解题思路：首先需要明白这个公式s[i]-s[j] = arr[j+1...i]的总和；
* 解释一下，s代表前n个数组元素的累加和，然后两个一相减就是后面j+1...i的总和；
* 这题的思路就是从0位置开始累加，利用一个map简直对形式的数组保存每次sum-k后的index，
* 每次保存的都是sum，i；就是前i个元素的和跟他的当前下标；然后如果后面某一次出现sum-k的值
* 刚好在map的key里面存在，此时就出现上面的公式这种情况了，就是说此时sum总和减去k后，
* 刚好是前面0...j的和，此时map里面sum-k对应的value的值刚好就是这个j，然后i-j的长度就是
* 此时满足所求的子数组，用一个变量不断的更新冷的值就行；
* */
public class GetMaxArrayLength {

    public static int getMaxArrayLength(int[] array,int k){
        if (array == null || array.length == 0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        //先保存(0,-1)这个点；
        /*map.put(0,-1);*/
        int len = 0;
        int sum = 0;
        for (int i = 0;i < array.length; i++){
            sum += array[i];//从0位置开始一直累加；
            if (map.containsKey(sum - k)){
                len = (i-map.get(sum-k)) > len ? (i-map.get(sum-k)) : len;
            }
            if (!map.containsKey(sum - k)){
                map.put(sum,i);
            }
        }

        return len;
    }

}
