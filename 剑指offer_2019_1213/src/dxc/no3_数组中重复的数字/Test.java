package dxc.no3_数组中重复的数字;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/13 23:08
 */
public class Test {

    public static void main(String[] args) {
        //三种测试用例
        int[] arr1 = new int[]{0,1,4,2,2,7,4,3,2,4};
        int[] arr2 = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] arr3 = new int[2];

        System.out.println(MultNumber.mulNumber3(arr1));
        System.out.println(MultNumber.mulNumber3(arr2));
        System.out.println(MultNumber.mulNumber3(arr3));

    }
}
