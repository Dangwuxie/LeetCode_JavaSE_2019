package dxc.no5_在其他数都出现偶数次的数组中找出出现奇次的数;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/27 21:57
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{
                4,4,5,5,6,6,7
        };
        int[] arr2 = new int[]{
                4,5,6,4,5,6,7,8
        };
        PrintOddTimesNum1.printOddTimesNum1(arr);
        PrintOddTimesNum1.printOddTimesNum2(arr2);
    }
}
