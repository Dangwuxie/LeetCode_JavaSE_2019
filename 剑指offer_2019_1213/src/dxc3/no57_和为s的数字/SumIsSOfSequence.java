package dxc3.no57_和为s的数字;

/**
 * @author dxc
 * @Title: SumIsSOfSequence
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 18:10
 */

/*
* 题目要求：和为s的连续正数序列；
* 输入一个整数sum，打印出所有和为s的连续整数序列，序列至少有两个数
* 例如：15，1+2+3+4+5=4+5+6=7+8=15,这个样子；
* */
/*
* 思路：依旧是两个左边卡边界，类似于移动窗口那样，small指向第一个数
* big指向第二个数，如果当前范围内的和小于s，那么big++
* 如果大于s，那么small++，等于s的时候就直接输出当前两个指针卡的范围内的数字
* */
public class SumIsSOfSequence {

    public static void getSequence(int sum){

        if (sum < 3){
            return;
        }
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = sum / 2;

        while (small <= mid){

            if (curSum == sum){
                printSequence(small,big);
            }
            while (curSum > sum){
                curSum -= small;
                small++;
                if (curSum == sum){
                    printSequence(small,big);
                }
            }

            big++;
            curSum += big;
        }
    }

    private static void printSequence(int left,int right){

        while (left <= right){
            System.out.print(left+"-");
            left++;
        }
        System.out.println();
    }

}













