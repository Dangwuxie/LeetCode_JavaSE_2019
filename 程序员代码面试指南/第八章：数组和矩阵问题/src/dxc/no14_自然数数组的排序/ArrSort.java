package dxc.no14_自然数数组的排序;

/**
 * @author dxc
 * @Title: ArrSort
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/7 21:54
 */
/*
* 问题：给定一个自然数组，长度为N；里面的数就是1-N之间不重复的数字
* 要求排序之后，由小到大的顺序进行排序，里面的数字从1-N，下标就是0-(N-1)；
*
* */
public class ArrSort {
    /*
    * 解法1：跳着交换，就是如果发现存在arr[i]!=i+1;
    * 此时使用temp保存当前的arr[i],然后将此数换到应该放到的位置
    * 此时需要将被交换的位置的数用tmp保存下来，while循环
    * 一直下去，直到arr[i]==i+1;
    * */
    public static void sort1(int[] arr){
        int tmp = 0;
        int next = 0;//保存被交换位置的数字

        for (int i = 0;i < arr.length; i++){
            tmp = arr[i];

            while (arr[i] != i+1){
                next = arr[tmp-1];
                arr[tmp-1] = tmp;
                tmp = next;
            }
        }
    }
    /*
    * 直接交换法：遍历的时候，如果发现存在arr[i]!=i+1;
     * 那么就交换arr[i]和arr[arr[i]-1]处的数字，
     * while循环，知道arr[i]==i+1即可；
    * */
    public static void sort2(int[] arr){
        int tmp = 0;

        for (int i = 0;i < arr.length; i++){

            while (arr[i] != i+1){
                tmp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
