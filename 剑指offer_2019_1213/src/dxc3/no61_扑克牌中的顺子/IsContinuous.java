package dxc3.no61_扑克牌中的顺子;

import dxc2.Swap;

/**
 * @author dxc
 * @Title: IsContinuous
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/24 14:41
 */
public class IsContinuous {

    public static boolean isContinuous(int[] arr){

        if (arr == null){
            return false;
        }
        //首先对数组进行排序
        bubbleSort(arr);

        //统计数组中0的个数
        int timesOfZero = 0;
        for (int i = 0;i < arr.length; i++){
            if (arr[i] == 0){
                timesOfZero++;
            }
        }
        //统计数字之间有间隔的
        int interval = 0;
        for (int i = timesOfZero + 1;i < arr.length; i++){
            if (arr[i] == arr[i-1]){
                return false;
            }
            interval  = interval + (arr[i] - arr[i-1] - 1);
        }

        if (interval > timesOfZero){
            //说明大小王无法补齐间隔
            return false;
        }

        return true;
    }

    private static void bubbleSort(int[] arr){

        if (arr == null || arr.length < 2){
            return;
        }

        for (int k = arr.length-1;k > 0; k--){
            for (int i = 0;i < k; i++){
                if (arr[i] > arr[i+1]){
                    Swap.swap(arr,i,i+1);
                }
            }
        }

    }

}
