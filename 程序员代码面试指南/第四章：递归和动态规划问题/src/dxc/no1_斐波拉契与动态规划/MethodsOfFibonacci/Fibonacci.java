package dxc.no1_斐波拉契与动态规划.MethodsOfFibonacci;

/**
 * @author 灵魂编程者
 * @Title: Fibonacci
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/16 11:03
 */
public class Fibonacci {
    /*
    * 第一种求法，暴力递归，复杂度O(2^n)
    * */
    public static int f1(int n){
        if (n < 1){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        //从第三个开始递归求解
        return f1(n-1)+f1(n-2);

    }

    /*
    * 第二种，迭代法，复杂度O(N)
    * */
    public static int f2(int n){
        if (n < 1){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }

        //定义三个变量不停的往前迭代计算
        int a = 1;
        int b = 1;

        int tmp = 0;
        for (int i=3;i<=n;i++){
            //b始终
            tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }

    /*
    * 第三种，复杂度为O(logN),
    * 使用矩阵乘法的形式表示
    * 求解斐波拉契数列第N项的问题变成了求解2*2矩阵的N-2次方再乘以(1,1);
    * （F(N),F(N-1)）
    *   =(F(N-1),F(N-2))*((1,1),(1,0))^(N-2);
    *
    * 例如：   (F(4),F(3))
    *       =(F(3),F(2))*((1,1),(1,0))
    *       =(1,1)*((1,1),(1,0))^2;
    * */

    public static int f3(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }

        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0]+res[1][0];
    }

    public static int[][] matrixPower(int[][] m,int p){
        int[][] res = new int[m.length][m[0].length];
        for (int i=0;i < res.length;i++){
            res[i][i]=1;
        }
        int[][] tmp = m;
        for (;p!=0;p>>=1){
            if ((p&1)!=0){
                res=multmatrix(res,tmp);
            }
            tmp = multmatrix(tmp,tmp);
        }

        return res;
    }

    private static int[][] multmatrix(int[][] tmp1,int[][] tmp2){
        int[][] res = new int[tmp1.length][tmp2[0].length];
        for (int i=0;i<tmp1.length;i++){
            for (int j=0;j<tmp2[0].length;j++){
                for (int k=0;k<tmp2.length;k++){
                    res[i][j]+=tmp1[i][k] * tmp2[k][j];
                }
            }
        }

        return res;
    }
}
