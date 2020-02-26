package dxc3.no56_数组中数字出现的次数;

/**
 * @author dxc
 * @Title: TimesOfAppear2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 14:01
 */
/*
* 当一个数组中的数组，都是出现了3次，但只有一个出现了一次，求这个数字
* */
/*
* 思路，如果其他所有的数字出现的次数都是三次，那么把这些数字二进制表示的每一位都加起来
* 如果32位中某一位的和可以被3整除，那么只出现1次的数字在那一位就是0，否则就是1；
* */
public class TimesOfAppear2 {

    public static int findNumber(int[] arr){

        if (arr == null){
            return 0;
        }
        //32位,保存顺序从0-31，从最高位到最低位
        int[] bitSum = new int[32];

        for (int i = 0;i < arr.length; i++){
            int flag = 1;
            for (int j = 31;j >= 0; --j){
                int bitFlag = flag & arr[i];
                if (bitFlag != 0){
                    //说明二进制中的当前这一位不为0；
                    bitSum[j] += 1;
                }
                //从最右边的最低位移动到最左边的最高位;
                //判断32次;
                flag = flag << 1;
            }
        }

        int result = 0;
        for (int i = 0;i < bitSum.length; i++){
            //此时计算的结果，就是那个唯一出现一次的数字，最高为每次左移一位
            result = result << 1;
            result += bitSum[i]%3;

        }

        return result;
    }


}







