package dxc2.no46_把数字翻译成字符串;

/**
 * @author dxc
 * @Title: DigitTranslateString
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/17 17:51
 */
/*
*题目要求：给定一个数组按照如下规则翻译成字母，
* 0->a,1->b,25->z;这样，给的一串数字有多种不同翻译
* 12258,->bccfi,->bwfi,->bczi,->mcfi,->mzi
* 请实现一个函数，计算一个数字可以有多少种不同的翻译方法；
* */
/*
* 思路：首先想到的是递归，比如1和2258，2258递归2和258，
* 12和258，往下递归，此时出现了两次258，所以会出现重复的问题
* 我们可以从数组后面往前面翻译，迭代式翻译，一个for循环搞定
* */
/*
* 注意细节，从倒数第一个数字开始翻译，
* 倒数第二个就要考虑是不是再10-25这个范围里面
* 因为每次都是当前的数字跟后面数字往后部分的组合，
* 如果当前的数字和后一个数字组成可以翻译，
* 那么就需要再加上i+2以及往后部分的组合个数；
* 如果不能组合，就单纯的加个下一个数字往后的组合数再加1，
* 当前数字只能在总数里面加上1
* */
public class DigitTranslateString {

    public static int getString(int number){

        if (number < 0){
            return 0;
        }

        return getTranslationCount(String.valueOf(number));
    }

    private static int getTranslationCount(String number){

        char[] arr = number.toCharArray();
        int[] counts = new int[number.length()];
        int count = 0;

        for (int i = arr.length-1;i >= 0; --i){
            //每次循环将count置为0
            count = 0;
            if (i < arr.length - 1){
                //先把后一个数字往后的组合个数加上
                count += counts[i+1];
            }else {
                count = 1;
            }
            if (i < arr.length - 1){
                //从倒数第二个数字开始要判断是否可以
                // 与后一个数字组成后转换成字母
                int digit1 = arr[i] - '0';
                int digit2 = arr[i+1] - '0';
                int sum = digit1*10 + digit2;
                //字母对应数字从0-25
                if (sum >= 10 && sum <= 25){
                    //如果当前数字可以和后一个数字组成字母，
                    //这种情况需要再加上i+2位以后的组合个数
                    //如果是最后两个数字，那么此时count再加1就行，1种情况；
                    //如果不是，那么这一种情况和i+2位后部分的组合可以再次重排列；
                    if (i < arr.length-2){
                        count += counts[i+2];
                    }else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }
}










