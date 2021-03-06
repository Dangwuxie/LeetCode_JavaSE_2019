package dxc3.no60_n个骰子的点数;

/**
 * @author dxc
 * @Title: PrintProbabilitionOnCirculation
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/23 18:30
 */
/*
* 循环法解决骰子问题；两个数组，总和就是num-num*6；
* 先从第一个骰子开始，一个数组的1-6下标都加1；
* 第二个骰子的时候，总和就是2-12；
* 此时从2开始，就是上一个骰子的点数分别加1、2...6;
* 比如第二个骰子投出后总和为7，那么这个7可以有6中情况。
* 就是上一个骰子点数为1时+6，2+5...6+1;所以说，
* 这一轮点子的总和为n出现的次数，就是上一轮n-1\n-2....n-6
* 的6个情况的次数总和；两个数组重复使用，加个标志就可以；
* */
public class PrintProbabilitionOnCirculation {

    public static void printOnCirculation(int num){

        if (num < 1){
            return;
        }
        //骰子的点数最少从1开始，所以下标就是从1开始，最高访问到6*n;
        int[][] probability = new int[2][];
        probability[0] = new int[num * 6 + 1];
        probability[1] = new int[num * 6 + 1];
        //由于是循环，所以先从第一个骰子开始，
        int flag = 1;
        for (int i = 1;i <= 6; i++){
            probability[flag][i] = 1;
        }
        if (num > 1){
            //从第二个骰子开始，因为总数为n的点数，有6种情况
            //n-1,n-2...n-6;当前的骰子可以摇6种情况；就是加上另外一个数组统计的次数
            //循环相加
            for (int k = 2;k <= num; k++){
                //下面就是开始，n的时候，加上上一轮数组的n-1,n-2.n-3....n-6的结果

                for (int i = k;i <= num*6; i++){
                    int count = 1;
                    while (count <= 6 && i - count > 0){
                        probability[1 - flag][i] += probability[flag][i - count];
                        count++;
                    }
                }
                //由于两个数组要重复使用，清零的数组是这一轮存储结果的数组
                //所以是另外一个数组，不是上一轮保存结果的数组；
                //从2开始，先把上一次统计后不再出现的下标清零
                //比如2个骰子的时候，1就不会出现；7个的时候，1--6就不会出现
                for (int i = 1;i < k; i++){
                    probability[1 - flag][i] = 0;
                }

                flag = 1 - flag;
            }
        }

        double total = Math.pow(6,num);

        for (int i = num;i <= num*6; i++){

            System.out.println(i+"的概率为:"+(probability[flag][i])/total);
        }


    }

}

/*
2的概率为:0.027777777777777776
3的概率为:0.05555555555555555
4的概率为:0.08333333333333333
5的概率为:0.1111111111111111
6的概率为:0.1388888888888889
7的概率为:0.16666666666666666
8的概率为:0.1388888888888889
9的概率为:0.1111111111111111
10的概率为:0.08333333333333333
11的概率为:0.05555555555555555
12的概率为:0.027777777777777776
*/
/*
2出现的机率：0.027777777777777776
3出现的机率：0.05555555555555555
4出现的机率：0.08333333333333333
5出现的机率：0.1111111111111111
6出现的机率：0.1388888888888889
7出现的机率：0.16666666666666666
8出现的机率：0.1388888888888889
9出现的机率：0.1111111111111111
10出现的机率：0.08333333333333333
11出现的机率：0.05555555555555555
12出现的机率：0.027777777777777776
*/