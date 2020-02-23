package dxc2.no49_丑数;

/**
 * @author dxc
 * @Title: TheKthUglyNumber2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/20 18:57
 */
/*
* 思路：牺牲空间换时间的方法；用一个数组一路保存丑数到第index个丑数；
* */
public class TheKthUglyNumber2 {

    public static int getKthUglyNumber2(int index){

        if (index <= 0){
            return 0;
        }

        int[] uglyArr = new int[index];
        int nextUgly = 1;//下标
        uglyArr[0] = 1;//丑数
        int mult2 = 0;//下标
        int mult3 = 0;//下标
        int mult5 = 0;//下标

        while (nextUgly < index){

            int min = Math.min(uglyArr[mult2] * 2,uglyArr[mult3] * 3);
            min = Math.min(min,uglyArr[mult5] * 5);
            uglyArr[nextUgly] = min;

            //这三个循环，保证已经进入丑数数组的每个数都要乘一次2、3和5；
            //很细节
            while (uglyArr[mult2]*2 <= uglyArr[nextUgly]){
                mult2++;
            }
            while (uglyArr[mult3]*3 <= uglyArr[nextUgly]){
                mult3++;
            }
            while (uglyArr[mult5]*5 <= uglyArr[nextUgly]){
                mult5++;
            }
            nextUgly++;
        }

        int ugly = uglyArr[nextUgly - 1];

        return ugly;
    }
}







