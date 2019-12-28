package dxc.no5_在其他数都出现偶数次的数组中找出出现奇次的数;

/**
 * @author dxc
 * @Title: PrintOddTimesNum1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/27 22:08
 */
/*
* 时间复杂度为O(N),额外空间复杂度为O(1);
* */
public class PrintOddTimesNum1 {
    /*
    * 第一种：只有一个出现次数为偶数的数；
    * 不停的异或操作就行；因为偶数个的相同的数最终的异或结果终为0
    * 只有奇数个的时候，最后的结果就是这个数本身；
    * 从0开始异或
    * */
    public static void printOddTimesNum1(int[] arr){
        int ret = 0;
        for (int cur : arr){
            ret ^= cur;
        }
        System.out.println(ret);
    }
    /*
    * 第二种：当有两个出现次数为奇数的数的时候
    * 也就是说，第一遍的异或结果是A^B的结果，
    * 可以这样考虑，结果的二进制中肯定存在1，那么这个不为0的位肯定是A或者B中间的一个；
    * 可以再次用0遍历一次，这次遍历的对象就是A^B中不为0位，第k位
    * 就是第k位不为0的数，异或完毕之后，留下的这个数肯定就是A或者B，
    * 再用第一次遍历留下的数跟其异或一次，遍求出另外一个数
    * */
    public static void printOddTimesNum2(int[] arr){
        int ret1 = 0;
        int ret2 = 0;

        for (int cur : arr){
            ret1 ^= cur;
        }
        //一个数与它的相反数进行与运算，留下的数有第k位为1，其余位都为0；
        int temp = ret1 & (~ret1 + 1);

        for (int cur : arr){
            if ((cur & temp) != 0){
                //说明第k位为1；
                ret2 ^= cur;
            }
        }

        System.out.println(ret2 + "and" + (ret1 ^ ret2));
    }
}
