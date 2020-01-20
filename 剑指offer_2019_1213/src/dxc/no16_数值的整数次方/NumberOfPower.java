package dxc.no16_数值的整数次方;

/**
 * @author dxc
 * @Title: NumberOfPower
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/19 22:30
 */
public class NumberOfPower {

    /*
    * 思路：首先需要考虑0这个特殊情况，当底数是0并且指数是负数的时候，(正数的话不影响)
    * 就需要进行特殊处理，不然会出现错误。其次，当底数不是0时，如果指数是负数的话，
    * 就需要求倒数，先把指数取绝对值，然后计算之后再次求倒数就行了；
    * */
    public static double numberOfPower1(int base,int exponent){

        if (base == 0 && exponent < 0){
            try {
                throw new Exception("错误的输入！");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -666;
        }

        int Exponent = exponent;

        if (exponent < 0){
            Exponent = -Exponent;
        }

        double result = powerOfUnsignedExponent2(base,Exponent);

        if (exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }
    /*
    * 整数、无符号指数，求结果
    * */
    private static int powerOfUnsignedExponent1(int base,int exponent){
        int result = 1;

        for (int i = 1;i <= exponent; i++){
            result *= base;
        }

        return result;
    }
    /*
    * 求解无符号指数整数幂的结果
    * 思路：可以利用递归的方法求某个数的n次幂，
    * a^n = (a^ n/2)*(a^ n/2);偶数
    * a^n = (a^ n-1/2)*(a^ n-1/2)*n;奇数
    * */
    private static int powerOfUnsignedExponent2(int base,int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }

        int result = powerOfUnsignedExponent2(base,exponent>>1);
        result *= result;//两个a^ n/2合成；

        if ((exponent & 1) == 1){
            //说明是奇数，这里面还需要再乘一次base，底数
            result *= base;
        }

        return result;
    }

}
