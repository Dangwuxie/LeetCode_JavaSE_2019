package dxc3.no60_n个骰子的点数;

/**
 * @author dxc
 * @Title: PrintProbability
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/23 15:03
 */
/*
*   基于递归求骰子每次的总点数，每次的点数总和s，
*   创建一个数组，长度就是筛子的总和s可能的总和范围
*   s作为下标，几个骰子，就递归几次，最后在数字中将个数加1；
* */
public class PrintProbability {

    public static void printProbability(int num){

        if (num < 1){
            return;
        }
        //n个骰子，那么总和的范围就是6*n-n;
        //用数组保存，以和s为下标，保存出现的次数,数组长度就是6*n-n+1;
        int[] probability = new int[num * 6 - num + 1];
        proCount(num,probability);
        double total = Math.pow(6,num);
        for (int i = 0;i < probability.length; i++){
            System.out.println(i+num+"出现的机率："+((double)probability[i] / (total)));
        }

    }

    private static void proCount(int num,int[] probability){
        //开始递归，从1开始，从第一个骰子开始
        for (int i = 1;i <= 6; i++){
            proCountCore(num,num,i,probability);
        }
    }

    private static void proCountCore(int original,int current,int sum,int[] probability){

        if (current == 1){
            //当current为1的时候，已经递归了num次此时直接给对应下标++就可以了
            probability[sum - original]++;
        }else {
            for (int i = 1;i <= 6; i++){
                proCountCore(original,current - 1,sum + i,probability);
            }
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