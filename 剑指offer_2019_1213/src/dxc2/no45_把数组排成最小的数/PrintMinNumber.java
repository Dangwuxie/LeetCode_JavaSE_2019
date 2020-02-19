package dxc2.no45_把数组排成最小的数;

/**
 * @author dxc
 * @Title: PrintMinNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/17 13:05
 */

/*
* 题目要求：输入一个正整数数组，把数组里所有数字拼接起来排成一个数
* 打印能拼出的所有数字中最小的以恶搞；例如{3，32，321}-->321323;
* */
public class PrintMinNumber {
    /*
    * 迭代式增加字符串长度，知道最后一个数字;
    * 从头开始，两个字符前后两种组合，比较大小，小的赋值给pre
    * pre保存的是前面的数字拼接在一起后最小的，继续向后迭代式增加；
    * */
    public static void printMinNumber(int[] arr){

        String pre = String.valueOf(arr[0]);

        for (int i = 1;i < arr.length; i++){
            //迭代式遍历比较
            String str = String.valueOf(arr[i]);
            pre = compareAndCombine(pre+str,str+pre);
        }

        System.out.println(pre);
    }

    private static String compareAndCombine(String str1,String str2){
        //两个字符串长度肯定相等，就是比较前后顺序时的大小
        char[] strs1 = str1.toCharArray();
        char[] strs2 = str2.toCharArray();

        for (int i = 0;i < str1.length(); i++){
            if ((strs1[i] - '0') < (strs2[i] - '0')){
                return str1;
            }else if ((strs1[i] - '0') > (strs2[i] - '0')){
                return str2;
            }
        }
        //如果上面的for循环么有返回，那么说两串数字大小相等，随便返回一个
        return str1;
    }
}





