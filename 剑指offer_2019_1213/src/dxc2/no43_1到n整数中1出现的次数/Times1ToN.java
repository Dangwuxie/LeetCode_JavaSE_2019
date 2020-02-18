package dxc2.no43_1到n整数中1出现的次数;

/**
 * @author dxc
 * @Title: Times1ToN
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/15 13:35
 */
/*
* 输入一个整数n，求1-n这n个整数的十进制表示中1出现的次数；
* 例如输入12，1-12这些整数中包含1的数字有1、10、11、12，
* 1一共出现了5次；
* */
public class Times1ToN {

    public static int appearTimes(char[] arr,int firstIndex){

        if (arr == null || arr.length == 0 || firstIndex == arr.length){
            return 0;
        }
        int first = arr[firstIndex] - '0';
        if (arr.length == 1 && first == 0){
            return 0;
        }
        if (arr.length == 1 && first > 0){
            //个位数字
            return 1;
        }
        //如果位数大于1.从两位数开始，
        int numFirst = 0;
        if (first > 1){
            numFirst = powerBase10(arr.length - 1 - firstIndex);
        }else if (first == 1){
            //如果第一位是1，那么第一位含有1的个数就是后面数字的总和加1；
            numFirst = lastNum(arr,firstIndex);
        }
        //下面就是求除了第一位剩余位为1的情况，
        //例如1-21345；目前只求1346-21345这两万个数字中含1的个数；
        //此时10000-19999已经求出，然后求的是剩余位的匹配组合，
        //剩余位就是0-9加上位数组合了；
        //一共5位，万位的已经求完，剩余四位就是4*10*10*10;
        //比如1346-11345和11346-21345；这两个一万个数，刚好四个位上可以全排列；
        //四位中轮流每一位为1，其余三位0-9组合；最后就是万位的大小再乘上；
        int numOther = first * (arr.length - 1) * powerBase10(arr.length - 2);
        //除去第一位，剩余位继续递归;就是说一开始求就是1346-21345之间刚好两万个数
        //下面就是1345继续递归了；
        int numLast = appearTimes(arr,firstIndex+1);

        return numFirst + numOther + numLast;
    }

    private static int powerBase10(int n){

        int res = 1;
        for (int i = 0;i < n; i++){
            res *= 10;
        }
        return res;
    }

    private static int lastNum(char[] arr,int firstIndex){

        int lastIndex = arr.length - 1;
        int tmp = 1;
        int res = 0;

        while (lastIndex-- > firstIndex){
            res += (arr[lastIndex] - '0')  * tmp;
            tmp *= 10;
        }
        return res;
    }
}







