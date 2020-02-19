package dxc2;

/**
 * @author dxc
 * @Title: Swap
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/11 13:12
 */
public class Swap {

    public static void swap(int[] arr,int l,int r){

        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;

    }

}
