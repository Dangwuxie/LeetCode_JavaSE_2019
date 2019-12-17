package dxc.no5_2_按序合并两个已排序的数组;

/**
 * @author dxc
 * @Title: MergeArray
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/17 22:01
 */
/*
* 题目要求：给定两个已经排序好的数组A1,A2，A1的末尾有足够的空间可以将A2数组全部复制过来
* 请实现一个函数，将A2中的所有数字插入到A1中去，并且所有的数字都是排序的；
* 最后返回数组A；
* */
public class MergeArray {
    /*
    * 实现思路：逆序复制法，与之前的替换字符串中的空格的思路一样，
    * 从末尾到前一个一个的复制；
    * */
    public static int[] mergeArray(int[] arr1,int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int sumLen = len1+len2;
        int[] sumArr = new int[sumLen];
        int pA = len1 - 1;
        int pB = len2 - 1;
        //i指针用来从A数组的最终长度向前复制数字
        int i = sumLen - 1;
        //while循环开始往前遍历
        //当pA指针等于-1的时候，说明A1数组刚开始的数字已经全部放到指定位置，
        //此时如果pB不等于-1，那么就是pB和i开始依次往前复制
        //否则A2数组复制完毕；
        //当pB指针等于-1的时候，说明A2数组中的数字已经全部放到A1的指定位置，
        //此时就不需要复制了；
        while (pA != -1 && pB != -1){

            if (arr2[pB] >= arr1[pA]){
                //如果两个数相等，那么A组的数字会排在B数组的前面
                sumArr[i--] = arr2[pB--];
            }else {
                //否则就是A数组中的数字大；
                sumArr[i--] = arr1[pA--];
            }
        }

        if (pB == -1){
            //如果pB等于-1了，那么此时数组依旧复制完成
            // 直接返回arr1就行
            return arr1;
        }else if (pA == -1){
            //此时可能pB依旧没有复制完成，需要完成复制
            while (pB != -1){
                sumArr[i--] = arr2[pB--];
            }
        }

        return sumArr;
    }
}















