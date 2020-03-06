package dxc3.no65_不用加减乘除做加法;

/**
 * @author dxc
 * @Title: Add
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/25 21:18
 */
/*
* 通过位运算，二进制的位运算来实现加法
* 两个数相加，如果相同的位分别为1或者0.
* 那么相加后这个位不会产生进位
* 如果都是1，那么相加后就会进位；
* 可以循环，先异或，加上不会进位的
* 在与运算左移一位，与运算只有当两个位都是1的时候结果不会是0
* 此时刚好左移一位，刚好进位；
* */
public class Add {

    public static int add(int num1,int num2){

        int sum = 0;
        int carry = 0;

        while (num2 != 0){
            //当进位不等于0的时候
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }

        return num1;
    }

}
