package dxc.真题564_依次增大的整数数组找出所有元素等于下标的i;

import java.util.ArrayList;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 21:33
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,7,7,8,9,9,9,9,9,14,14,14,14,14,14,14};
        ArrayList<Integer> list = FindI.findi(arr);
        System.out.println(list);
    }
}
