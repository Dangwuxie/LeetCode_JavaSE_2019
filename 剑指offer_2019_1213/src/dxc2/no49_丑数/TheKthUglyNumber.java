package dxc2.no49_丑数;

/**
 * @author dxc
 * @Title: TheKthUglyNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/20 18:22
 */
/*
* 题目要求：把因子只包含2、3、5的数称作丑数，求从小到大的第1500个丑数；
* 就是说对这三个数取余为0， 并且连续除以这个数后为1，那么这个数就是丑数；
* */
public class TheKthUglyNumber {
    /*
    * 思路，从1开始遍历，找第1500个丑数
    * */
    public static int getKthUglyNumber(int index){

        if (index <= 0){
            return 0;
        }

        int count = 0;
        int getUgly = 0;

        while (getUgly < index){
            count++;
            if (isUgly(count)){
                getUgly++;
            }
        }

        return count;
    }

    private static boolean isUgly(int number){
        while (number % 2 == 0){
            number /= 2;
        }
        while (number % 3 == 0){
            number /= 3;
        }
        while (number % 5 == 0){
            number /= 5;
        }

        return (number == 1) ? true : false;
    }
}
