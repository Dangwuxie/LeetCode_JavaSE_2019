package dxc.no5_2_按序合并两个已排序的数组;

import dxc.PrintArray;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/17 22:00
 */
public class Test {

    public static void main(String[] args) {
        int[] arr1 = new int[]{6,7,8,9,10};
        int[] arr2 = new int[]{1,2,3,4,5,6};
        PrintArray.printArray(MergeArray.mergeArray(arr1,arr2));

    }
}
