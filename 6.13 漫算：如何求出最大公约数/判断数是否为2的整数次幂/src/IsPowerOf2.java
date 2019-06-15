/**
 * @author Dangxuchao
 * @Title: IsPowerOf2
 * @ProjectName 6.13 漫算
 * @Description: 位运算判断一个数是否是2的整数次幂
 *
 * 解题思路：首先，2的整数次幂转换成二进制后都是最高位只有一个1
 * 然后它减去一个1之后的二进制就是少一位，其余位全是1；
 * 两者进行与运算，如果如果是2的整数次幂的话会返回0，否则返回1；
 * 例如：4：100;减1为3:11；
 * 二进制进行与运算，100&11--->0;
 *
 * @date 2019/6/15 20:55
 */
public class IsPowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(16));
        System.out.println(isPowerOf2(31));
        System.out.println(isPowerOf2(256));
        System.out.println(isPowerOf2(1024));
        System.out.println(isPowerOf2(1025));
    }
    public static boolean isPowerOf2(int num){
        return (num&(num-1)) == 0;
    }
}
