package dxc.no3_只用位运算不用算术运算实现整数的加减乘除运算;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/26 14:55
 */
public class Test {

    public static void main(String[] args) {
        int a = 22;
        int b = 2;
        /*System.out.println(Calculate.add(a,b));*/
        int c = -2147483648;
        int d = 123;
        /*System.out.println(Calculate.minus(a,b));*/
       /* System.out.println(Calculate.multi(a,b));*/
        System.out.println(Calculate.divide(d,c));
    }

}
