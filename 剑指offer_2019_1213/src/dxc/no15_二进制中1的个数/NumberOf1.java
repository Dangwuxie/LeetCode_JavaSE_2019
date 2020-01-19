package dxc.no15_二进制中1的个数;

/**
 * @author dxc
 * @Title: NumberOf1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/19 21:08
 */
public class NumberOf1 {
    /*
    * 第一种思路：利用1一直与运算，一位一位的与，
    * 如果&之后等于1，那就计数，与运算32次
    * */
    public static int numberOf1_1(int n){
        int cur = 1;
        int count = 0;

        while (cur > 0){
            if ((n & cur) != 0){
                count++;
            }

            cur = cur << 1;
        }

        return count;
    }
    /*
    * 第二种：将n每次与n-1进行与运算，就会将n二进制中最右边的1变成0，
    * 那么n的二进制中有多少个1，就会发生多少次与运算。
    * */
    public static int numberOf1_2(int n){

        int count = 0;

        while (n != 0){
            count++;
            n &= (n-1);
        }

        return count;
    }
}
