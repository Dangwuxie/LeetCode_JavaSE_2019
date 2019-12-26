package dxc.no3_只用位运算不用算术运算实现整数的加减乘除运算;

/**
 * @author dxc
 * @Title: Calculate
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/26 15:06
 */

/*
* 只用位运算不用算术运算实现整数的加减乘除运算;
* */
public class Calculate {

    /*
    * 解题思路：不考虑进位的情况加上只考虑进位的情况
    * 不考虑进位，a^b.就是所求结果
    * 考虑进位就是，(a & b) << 1,就是所求结果，
    * 一直循环的计算下去，当进位产生的值完全消失的时候，a^b就是所求的值；
    * */
    public static int add(int a,int b){
        int sum = 0;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    private static int negNum(int a){
        return add(~a,1);
    }

    /*
    * 实现a-b的运算很简单，就是a+(-b),
    * 一个数的相反数就是取反+1，-b = ~b+1;
    * */
    public static int minus(int a,int b){
        return add(a,negNum(b));
    }

    /*
    * 实现a.b两数乘法；
    * 每一次循环内容，b最右边是是1的时候，res = res + a;
    * 不管是不是1，都有a<<==1;b>>>=1;
    * */

    public static int multi(int a,int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0){
                res = add(res,a);
            }
            a <<= 1;
            b >>>= 1;
        }

        return res;
    }

    private static boolean isNeg(int n){
        return n < 0;
    }

    public static int div(int a,int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;

        for (int i = 31;i > -1;i = minus(i,1)){
            //没看懂
            if ((x >> i) >= y){
                res |= (1 << i);
                x = minus(x,y << i);
            }

        }

        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int a,int b){
        if (b == 0){
            throw new RuntimeException("分母为0！");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE){
            return 1;
        }else if (b == Integer.MIN_VALUE){
            return 0;
        }else if (a == Integer.MIN_VALUE){
            //当分子为负数最小值时
            int res = div(add(a,1),b);
            return add(res,div(minus(a,multi(res,b)),b));
        }else{
            return div(a,b);
        }
    }
}








