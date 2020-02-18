package dxc2.no44_数字序列中某一位的数字;

/**
 * @author dxc
 * @Title: DigitAtIndex
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/16 15:55
 */
/*
* 题目要求：数字以0123...9101112..99100...的格式序列化到一个字符序列中
* 在这个序列中第5位是5，从0开始计算，第13位是1，19位是4，
* 请写一个函数，求任意第n位对应的数字；
* */
public class DigitAtIndex {

    public static int getDigitAtIndex(int index){

        if (index < 0){
            return -1;
        }
        //从个位开始减
        int digit = 1;
        while (true){
            //首先统计个位的数字的个数
            //每次都要统计，因为如果继续循环的话就说明前面的1位、2位这些都已经排除了
            int number = countOfSum(digit);
            //此处number为几个n位数，乘以digit表示多少个单个的数
            if (index < number * digit){
                //如果小于的话说明刚好在当前的位数里面；
                return getDigit(index,digit);
            }
            index -= number * digit;
            digit++;
        }

    }

    private static int countOfSum(int digit){

        if (digit == 1){
            return 10;
        }
        //位数-1，10的n次方；两位的话就是10^1;
        int count = (int) Math.pow(10,digit-1);
        //统计位数
        return digit * count;
    }

    //此函数是我们已经知道要求的数字在哪一位后，求的；
    private static int getDigit(int index,int digit){
        //beginNumber要找的是几位数的第一个数，0，10，100这些数
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;

        for (int i = 1;i < indexFromRight; i++){
            number /= 10;
        }
        return number % 10;
    }

    private static int beginNumber(int digit){

        if (digit == 1){
            return 0;
        }

        return (int) Math.pow(10,digit - 1);
    }

}







