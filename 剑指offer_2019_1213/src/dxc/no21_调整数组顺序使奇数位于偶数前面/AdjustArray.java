package dxc.no21_调整数组顺序使奇数位于偶数前面;

/**
 * @author dxc
 * @Title: AdjustArray
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/28 23:18
 */
public class AdjustArray {

    /*
    * 第一种方法，两个指针分别从数组的最左边和最右边开始遍历
    *
    * */
    public static void adjustArray(int[] array){

        if (array == null || array.length == 0){
            return;
        }

        int left = 0;
        int right = array.length-1;

        while(left < right){

            while (left < right && (array[left]&1) == 1){
                //碰到偶数，停止遍历
                //如果是奇数，继续left++;
                left++;
            }

            while (left < right && (array[right]&1) != 1){
                //如果是偶数，与1发生为运算后是0
                right--;
            }

            if (left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

    }
}
