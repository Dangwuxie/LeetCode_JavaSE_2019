package dxc2.no39_数组中出现次数超过一半的数字;

import dxc2.RandomIndex;

import java.util.Random;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/10 21:29
 */
public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        int[] arr2 = new int[0];

        System.out.println(AppearTimesThanHalf2.appearThanHalf(arr));

        /*System.out.println(AppearTimesThanHalf.apperThanHalf(arr));*/
        /*System.out.println(arr2.length);*/
        /*for (int i =0 ;i < 20; i++){
            System.out.println(RandomIndex.randomIndex(5,10));
        }
        */
    }
}
