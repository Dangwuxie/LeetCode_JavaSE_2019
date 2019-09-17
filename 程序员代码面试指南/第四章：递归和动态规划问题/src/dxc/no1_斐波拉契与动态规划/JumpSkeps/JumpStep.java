package dxc.no1_斐波拉契与动态规划.JumpSkeps;

import dxc.no1_斐波拉契与动态规划.MethodsOfFibonacci.Fibonacci;

/**
 * @author 灵魂编程者
 * @Title: JumpStep
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/17 21:43
 */
/*
* 跳台阶问题，给个N阶台阶，每次能跳一个或者两个台阶
* 问有多少种跳台阶方法；
* 跟斐波拉契数列一个思路，所有跳到N阶的方法，
* 要么N-1阶跳一步到N阶
* 要么N-2阶跳2步到N阶，所以说是S(N)=S(N-1)+S(N-2);
*
* */
public class JumpStep {
    /*
    * 1、暴力递归，O(2^n)
    * */
    public static int s1(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2){
            return n;
        }
        //暴力递归
        return s1(n-1)+s1(n-2);
    }

    /*
    * 2、迭代法，O(N)
    * */
    public static int s2(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2){
            return n;
        }

        //开始迭代
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i=3;i<=n;i++){
            temp = b;
            b+=a;
            a = temp;
        }
        return b;
    }

    /*
    * 3、矩阵乘法，O(logN)
    * */

    public static int s3(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2){
            return n;
        }
        /*
        * 需要求出状态矩阵
        * */
        int[][]base = {{1,1},{1,0}};
        int[][]res = Fibonacci.matrixPower(base,n-2);

        return 2*res[0][0]+res[1][0];
    }
}













