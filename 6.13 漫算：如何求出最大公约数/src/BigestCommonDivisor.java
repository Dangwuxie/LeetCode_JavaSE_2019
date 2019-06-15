/**
 * @author Dangxuchao
 * @Title: BigestCommonDivisor
 * @ProjectName 6.13 漫算：如何求出最大公约数
 * @Description: 第一个，暴力枚举法
 * 这种方法实现的思路很简单，就是取较小整数的一半开始朝0遍历，
 * 两个整数同时对每一次的数字取余，满足整除最终返回最后保存下来的那个公约数；
 * 直到找到一个合适的整数；如果能找到一个合适的整数，那么就直接返回；
 * 可是此方法效率不行；
 * @date 2019/6/15 18:02
 */
public class BigestCommonDivisor {
    public static int baoLi(int a,int b){
        int big = a>b ? a:b;
        int small = a<b ? a: b;
        if (big % small == 0){
            return small;
        }

        //否则就从最小数的一半开始遍历往0遍历，找到第一个数字就返回
        // //找到最大的两个整数能同时整除的数字；
        for (int i = (small/2);i > 1;i--){
            if (small % i == 0&&big %i == 0){
                return i;
            }
        }

        return 1;
    }


    /**
     * 第二种：欧几里得算法，又称为辗转相除法；
     * 原理：一直两个正整数a和b，（a>b）,
     * 它们的最大公约数等于a除以b的余数c和B之间的最大公约数；
     * 例如100和25，25除以10余5，
     * 那么10和25之间的最大公约数等于10和5的最大公约数；
     */

    public static int getCommonDivisionV2(int a,int b){
        int big = a>b ? a:b;
        int small = a<b ? a: b;
        if (big % small == 0){
            return small;
        }

        return getCommonDivisionV2(big%small,small);

    }

    /**
     * 辗转相除法有个问题，当两个整数较大时，取a%b得性能会比较差。
     * 下面介绍更相减损法；
     * 思路：出自古代得九章算术；
     * 两个正整数a/b,他们得最大公约数等于a-b得差值c和较小数b的最大公约数；
     * 就这样一直减下去，直到两个数相等就好了
     */

    public static int getCommonDivisionV3(int a,int b){

        if (a == b){
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a: b;
        return getCommonDivisionV3(big-small,small);
    }

    /**
     * 最优解法：
     * 辗转相除法与更相减损法的优势结合起来，
     * 在更相减损法的基础上使用移位运算
     * 优势，既可以避免大整数取模，又可以尽可能的减少预算次数；
     * @param a
     * @param b
     * @return
     */
    public static int getCommonDivisionV4(int a,int b){
        if (a == b){
            return a;
        }
        if (((a&1) == 0) && (b&1) == 0){
            return getCommonDivisionV4(a>>1,b>>1)<<2;
        }else if ((a&1) == 0 && (b&1) != 0){
            return getCommonDivisionV4(a>>1,b);
        }else if ((a&1) != 0 && (b&1) == 0){
            return getCommonDivisionV4(a,b>>1);
        }else {
            //如果两个数都是奇数，
            // 先利用更相减损法运算一次，然后又可以金新下面的运算了
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return getCommonDivisionV4(big-small,small);
        }
    }
}
