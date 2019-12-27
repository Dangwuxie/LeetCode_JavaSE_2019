package dxc.no4_整数的二进制数表达中有多少个1;

/**
 * @author dxc
 * @Title: CountNum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/27 21:43
 */
/*
* 给定一个32位整数n，可以是0，可以是正负，返回二进制数中1的个数;
* */
public class CountNum {
    /*
    * 第一种方法：二进制数每次右移一位，直至为0；
    * */
    public static int countNum1(int n){
        int cout = 0;

        while (n != 0){
            cout += n & 1;
            n >>>= 1;
        }

        return cout;
    }

    /*
    * 第二种方法：可以每次n&(n-1),有多少个1就可以&操作多少次而不为0；
    * */
    public static int countNum2(int n){
        int count = 0;
        while (n != 0){
            n &= (n-1);
            count++;
        }
        return count;
    }
}
