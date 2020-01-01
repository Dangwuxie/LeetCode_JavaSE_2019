package dxc.no9_不重复打印排序数组中相加和为给定值的所有二元组和三元组;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/1 16:56
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{-8,-4,-3,0,1,2,4,5,8,9};

        PrintUniqueArr.printUniqueArr2(arr,10);
        /*
        *   1-9
            2-8
        * */
        /*
        *   -4-5-9
            -3-4-9
            -3-5-8
            0-1-9
            0-2-8
            1-4-5
        * */
    }
}
