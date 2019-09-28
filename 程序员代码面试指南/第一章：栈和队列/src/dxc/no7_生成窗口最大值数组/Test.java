package dxc.no7_生成窗口最大值数组;

import dxc.PrintArray;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/28 15:48
 */


public class Test {

    public static void main(String[] args) {
        int[] arr =
                {4,3,5,4,3,3,6,7};

        int[] res = GetMaxWindow.getMaxWindow(arr,3);
        PrintArray.printArray(res);
    }
}
