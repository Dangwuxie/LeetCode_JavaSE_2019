package dxc.no8_最长的可整合子数组的长度;

import java.util.Arrays;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/31 22:02
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,4,5,6,7};
        /*int[] arr2 = Arrays.copyOfRange(arr,0,2);
        for (int cur : arr2){
            System.out.println(cur);
        }*/


        System.out.println(GetLongLength.getLongLength2(arr));

    }
}
