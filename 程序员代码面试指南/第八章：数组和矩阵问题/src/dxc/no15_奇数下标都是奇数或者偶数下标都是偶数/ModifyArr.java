package dxc.no15_奇数下标都是奇数或者偶数下标都是偶数;

/**
 * @author dxc
 * @Title: ModifyArr
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/8 11:01
 */
/*
* 问题：给定一个长度大于2的数组，要求重新排序后
* 奇数下标的数是奇数，偶数下标的数是偶数
* 要求时间复杂度为O(N).额外空间复杂度为O(1);
* */
public class ModifyArr {
    /*
    * 解题思路，设定两个指针，even偶数指针，odd奇数指针
    * 分别从下标为0和1处开始，再来一个数字arr[N-1],就是数组最末尾的数字
    * 每次判断该数字是偶数还是奇数，是偶数，与arr[even]处的数字交换，然后even++
    * 如果是奇数，与arr[odd]处的数字交换，然后odd++；
    * 当even或者odd大于或者等于N时，停止交换，
    * 此时已经完成奇数下标处是奇数，偶数下标处是偶数的目标
    * */
    public static void modifyArr(int[]arr){
        //首先，照旧判空
        if (arr == null || arr.length < 2){
            return;
        }
        //三个指针遍历
        int even = 0;
        int odd = 1;
        int tail = arr[arr.length-1];

        while (even < arr.length && odd < arr.length){
            if (tail % 2 == 0){
                //是偶数
                swap(arr,even);
                even += 2;
            }else {
                //是奇数
                swap(arr,odd);
                odd +=2 ;
            }
        }

    }

    private static void swap(int[] arr,int index){
        int tmp = arr[index];
        arr[index] = arr[arr.length-1];
        arr[arr.length-1] = tmp;
    }
}
