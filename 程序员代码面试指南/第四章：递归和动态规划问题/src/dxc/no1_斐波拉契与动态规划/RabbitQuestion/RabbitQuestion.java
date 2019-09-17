package dxc.no1_斐波拉契与动态规划.RabbitQuestion;

/**
 * @author 灵魂编程者
 * @Title: RabbitQuestion
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/17 23:11
 */

/*
* 题目是，第一年一个成熟的兔子，从第二年开始每年生一个小兔子
* 兔子永不死亡，新生的兔子三年成熟后又开始生兔子，第N年兔子总共多少只？
*
* 分析：首先，1、2、3年的兔子数量为1，2，3；
* 类似于斐波拉契递归，不过兔子数量依赖的是n-1+n-3;
* 这里解释一下，首先，第N年成熟的兔子必然会翻倍，
* 所以C(N)先加上一个C(N-3),三年前的所有兔子在今年都会生兔子
* 然后在N和N-3这几年肯定又会有新的成熟的兔子，所以是C(N)=C(N-3)+C(N-1)
* 让C(n-1)继续递归；(n-2)+(n-1-3)
* */
public class RabbitQuestion {
    /*
    * 1、暴力递归，O(2^N)
    * */

    public static int s1(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2 || n==3){
            return n;
        }
        //暴力递归
        return s1(n-3)+s1(n-1);
    }

    /*
    * 2、迭代法 O(N)
    * */

    public static int s2(int n){
        if (n<1){
            return 0;
        }
        if (n==1 || n==2 || n==3){
            return n;
        }

        int a = 1;
        int b = 2;
        int c = 3;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i=4;i<=n;i++){
            tmp1 = b;
            tmp2 = c;
            c+=a;
            a = tmp1;
            b = tmp2;
        }
        return c;
    }
}
