package dxc.no5_需要排序的最短子数组长度;

import dxc.PrintArray;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/27 22:37
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2,6,7};
        int count = GetMinArrLength.getMinArrLength(arr);
        System.out.println(count);

    }
}
