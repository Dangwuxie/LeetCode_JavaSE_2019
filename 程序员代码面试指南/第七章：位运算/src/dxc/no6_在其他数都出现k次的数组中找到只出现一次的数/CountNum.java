package dxc.no6_在其他数都出现k次的数组中找到只出现一次的数;

/**
 * @author dxc
 * @Title: CountNum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/27 22:30
 */

/*
* 问题：给定一个整形数组arr和一个大于1的整数k，一直此数组中只有一个数出现了一次
* 其他的数都出现了k次；求出这个出现了k次的数；
* */
public class CountNum {
    /*
    * 解题方法，
    * 定理：k进制的两个数c和d的无进位相加的结果就是(c(i)+d(i))%k,注意是无进位相加
    * 那么k个k进制的数相加的结果一定是0，因为无进位；
    *
    * 可以用一个数0，遍历相加此数组中的数，最后留下来的k进制的数就是所要求的那个数；
    * */
    public static int countNum(int[] arr,int k){
        //已知eO是一个32位进制的数
        int[] eO = new int[32];

        for (int i = 0;i < arr.length; i++){
            //此循环就是将eO数组与每一个arr数组中的数按位无进位相加
            Add(eO,arr[i],k);
        }

        int res = getKFromNum(eO,k);
        return res;
    }

    private static void Add(int[] eO,int value,int k){
        //首先获取value的k进制数
        int[] Kvalue = getNumFromK(value,k);
        //下面就是将eO和Kvalue按位相加，无进位相加
        for (int i = 0;i < eO.length; i++){
            //定理：k进制的两个数c和d的无进位相加的结果就是(c(i)+d(i))%k
            eO[i] = (eO[i] + Kvalue[i]) % k;
        }
    }

    private static int[] getNumFromK(int value,int k){
        //将value转换成为k进制的数
        int[] res = new int[32];
        int index = 0;

        while (value != 0){
            res[index++] = value % k;
            value /= k;
        }

        return res;
    }

    private static int getKFromNum(int[] eO,int k){
        //此函数是将数组中的k进制的数转换成十进制的数
        int res = 0;
        for (int i = eO.length-1;i > -1; i--){
            res = res * k + eO[i];
        }

        return res;
    }

}








