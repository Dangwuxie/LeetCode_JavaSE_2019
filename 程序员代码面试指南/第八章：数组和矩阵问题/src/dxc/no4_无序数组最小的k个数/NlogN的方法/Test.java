package dxc.no4_无序数组最小的k个数.NlogN的方法;

import java.sql.SQLOutput;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/21 22:54
 */
public class Test {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {1,1,1,5,3,1,2,4,7,8,9};
        int[] minKNums = FindMinKNums.findMinKNums(arr,k);
        for (int mink:minKNums){
            System.out.print(mink+" ");
        }

    }

}
