package dxc.no3_数组中重复的数字;

/**
 * @author dxc
 * @Title: MultNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/13 23:09
 */
/*
* 题目要求：找出数组中重复的数字，重复的数字可能存在多个
* 返回任意一个；
* */
public class MultNumber {
    /*
    * 思路：题目要求是找出随机一个重复数字，
    * 所以求解的思路可以这样，找到第一个出现两次以上的数字就返回该数字
    *
    * 解法：从数组的第一个数字开始遍历，如果arr[i]==i，就接着扫描下一个数字
    * 如果arr[i]!=i，
    * 那么对比arr[i]和arr[arr[i]]，如果相等，那么就相等，就返回arr[i]
    * 否则就交换arr[i]和arr[arr[i]]
    * 此时继续上面的重复步骤，
    *
    * 时间复杂度为O(n),因为直接是在输入数组上进行的，因此额外空间复杂度为O(1);
    * */
    public static int multNumber(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        for (int i = 0;i < arr.length; i++){
            //直接while循环，直接找到arr[i]=i，然后停止while循环
            //继续下一个数字；

            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    //如果出现相等，就直接返回当前的这个数字
                    return arr[i];
                }
                //否则就交换
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return 0;
    }

}
