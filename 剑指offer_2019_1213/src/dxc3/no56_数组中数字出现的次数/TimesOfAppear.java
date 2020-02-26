package dxc3.no56_数组中数字出现的次数;

/**
 * @author dxc
 * @Title: TimesOfAppear
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 11:38
 */
/*
* 题目要求：数组只出现一次的两个数字；一个整型数组里除了两个数字之外
* 其他数字都出现了2次，请找出这两个数字；
* */
/*
* 思路，如果只出现一次的数字只有一个，那么从头异或到尾，剩下的就是那个数字；
* 因为异或，相同为0，不同为1；
* 可以这样做，如果是两个数字只出现了一次，那么最后的异或结果肯定就是这两个数字的异或结果
* 那么这个结果二进制中为1的某一位，肯定这两个数字中有一个在该位是1，另外一个是0；
* 所以可以根据这个把数组分成两部分，然后再异或，两个组最后的异或结果就是这两个数字；
* */
public class TimesOfAppear {

    public static void timesOfAppearInArray(int[] arr){

        if (arr == null || arr.length < 2){
            return ;
        }
        //两个数字异或后的结果
        int resultOfTwo = 0;
        for (int i =0 ;i < arr.length; i++){
            resultOfTwo ^= arr[i];
        }
        int indexRightOf1 = findFirstBitIs1(resultOfTwo);
        //分成两个数组
        int[] indexIs1 = new int[arr.length];
        int[] indexIs0 = new int[arr.length];
        int index0 = 0;
        int index1 = 0;

        for (int i = 0;i < arr.length ;i++){

            if (isBits1(arr[i],indexRightOf1)){
                indexIs1[index1++] = arr[i];
            }else {
                indexIs0[index0++] = arr[i];
            }
        }

        int res1 = 0;
        int res2 = 0;

        for (int i = 0;i < indexIs0.length; i++){
            res1 ^= indexIs1[i];
            res2 ^= indexIs0[i];
        }
        System.out.println(res1+"-"+res2);
    }

    private static boolean isBits1(int number,int index){
        number = number >> index;
        return (number&1) == 1;
    }

    private static int findFirstBitIs1(int res){
        //找当前的数字二进制最右边的1,返回这个1的下标
        int indexOf1 = 0;

        while ((res&1) == 0 && indexOf1 < 32){
            res = res >> 1;
            indexOf1++;
        }
        return indexOf1;
    }
}










