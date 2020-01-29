package dxc.no21_调整数组顺序使奇数位于偶数前面;

import dxc.PrintArray;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/28 21:30
 */
public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};

        AdjustArray.adjustArray(arr);

        PrintArray.printArray(arr);
        /*
        * 1,5,3,4,2,
        * */
    }
}
