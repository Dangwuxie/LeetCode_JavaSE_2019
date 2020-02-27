package dxc3.no57_和为s的数字;

/**
 * @author dxc
 * @Title: TwoNumberOfSumIsK
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 16:27
 */
/*
* 题目要求：输入一个递增排序的数组和一个数字s，在数组中查找两个数，
* 使得它的和正好是s，如果有多个，全部输出；
* */
/*
* O(N)的时间复杂度的算法：两个指针，small，big，
* small在最左，big在最右，
* 每次两个指针所指的元素相加，如果比k大，big--
* 如果比k小small++就可以了
* */
public class TwoNumberOfSumIsK {

    public static void findTwoNumbers(int[] arr,int k){
        if (arr == null || arr.length < 1){
            return;
        }

        int small = 0;
        int big = arr.length - 1;

        while (small < big){

            int tmpSum = arr[small] + arr[big];
            if (tmpSum == k){
                System.out.println(arr[small]+"--"+arr[big]);
                big--;
                small++;
            }else if (tmpSum < k){
                small++;
            }else {
                big--;
            }
        }

    }
}




