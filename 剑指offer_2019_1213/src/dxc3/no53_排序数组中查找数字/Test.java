package dxc3.no53_排序数组中查找数字;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/12 18:13
 */
public class Test {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,3,3,3,4,4,5};
        //System.out.println(AppearTimesInOrder.findNumberInOrder(arr,4));

        int[] arr2 = new int[]{0,1,2,3,5};//4
        int[] arr3 = new int[]{0};//-1
        int[] arr4 = new int[]{0,1,2,3,4};//5
        int[] arr5 = new int[]{1,2,3,4,5};//0
        System.out.println(FindSingleInOrderArr.findNumber(arr2,5));
        System.out.println(FindSingleInOrderArr.findNumber(arr3,1));
        System.out.println(FindSingleInOrderArr.findNumber(arr4,5));
        System.out.println(FindSingleInOrderArr.findNumber(arr5,5));

    }
}
