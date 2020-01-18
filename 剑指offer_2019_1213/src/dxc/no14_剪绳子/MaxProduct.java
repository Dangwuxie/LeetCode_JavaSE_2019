package dxc.no14_剪绳子;

/**
 * @author dxc
 * @Title: MaxProduct
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/17 13:03
 */
/*
* 思路：按照从下往上的顺序来计算，用数组保存绳子长度从1到n的
* 最大乘积，数组下标就是0-n-1；
* products数组要保存的元素一直都是当前下标i也就是i长度的绳子的最大乘积
* 数组中第i个元素表示把长度为i的绳子的最大乘积值；
*
* 为了求解f(i)的乘积最大值，需要求出所有可能的f(j)*f(i-j)的值，并比较处最大值
* 比如求f(8),就要求f(1)*f(7)、f(2)*f(6),f(3)*f(5),f(4)*f(4)，这些中的最大值
* */
public class MaxProduct {
    /*
    * 第一种，动态规划法，O(N^2)的时间复杂度，O(N)的额外空间
    * */
    public static int getMaxProduct1(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }

        //因为长度为1是从0下标开始的，length长度的绳子，
        //下标要访问到length下标，数组长度需要length+1；
        int[] products = new int[length + 1];
        products[0] = 0;//第一个长度的乘积
        products[1] = 1;//2
        products[2] = 2;//3
        products[3] = 3;//第四个长度的乘积

        int max = 0;

        for (int i = 4;i <= length; i++){

            max = 0;
            for (int j = 1;j <= i/2; j++){
                int temp = products[j] * products[i - j];
                max = temp > max ? temp : max;
            }
            products[i] = max;
        }
        max = products[length];

        return max;
    }
    /*
    * 贪婪算法，O(1)的时间空间复杂度
    * 当n>=5时，尽可能多的剪长度为3的绳子；当剩下的绳子为4时，剪成两个2，
    *  就是说当n>=5的时候，3*(n-3)总是>=2*(n-2)，所以我们需要尽可能多的剪长度为3的子绳子
    * */
    public static int getMaxProduct2(int length){

        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }

        int times3 = length / 3;

        if (length - times3*3 == 1){
            times3 -= 1;
        }
        int times2 = (length - times3*3) / 2;

        return (int) (Math.pow(3,times3) * Math.pow(2,times2));
    }
}










