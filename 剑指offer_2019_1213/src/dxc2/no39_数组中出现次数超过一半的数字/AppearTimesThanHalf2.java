package dxc2.no39_数组中出现次数超过一半的数字;

/**
 * @author dxc
 * @Title: AppearTimesThanHalf2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/11 14:26
 */
/*
* 思路2，很简单，既然是出现次数超过数组个数一半的数字
* 那么这个数字的出现次数必定比其余所有数字的个数和还大
* 可以这样，定义两个变量res和times
* res从第一个数字开始保存，times为1，
* 往后遍历，如果相同，times+1，否则-1
* 如果此时times为0，那么就要保存下一个数字
* 保存后times为1，继续遍历直到完毕，最后的res肯定是所要求的数字
* 时间复杂度为O(N);
* */
public class AppearTimesThanHalf2 {

    public static int appearThanHalf(int[] arr){

        if (arr == null || arr.length == 0){
            return 0;
        }

        int res = arr[0];
        int times = 1;

        for (int i = 1;i < arr.length; i++){
            if (times == 0){
                res = arr[i];
                times = 1;
            }else if (res == arr[i]){
                times++;
            }else {
                times--;
            }
        }

        if (!checkMoreThanHalf(arr,res)){
            res = 0;
        }

        return res;
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
