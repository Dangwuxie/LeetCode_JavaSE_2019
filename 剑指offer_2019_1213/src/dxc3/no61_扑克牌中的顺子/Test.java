package dxc3.no61_扑克牌中的顺子;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 22:03
 */
public class Test {

    public static void main(String[] args) {


        int[] arr = new int[]{1,3,5,0,0};
        int[] arr2 = new int[]{1,2,3,0,0};
        int[] arr3 = new int[]{1,7,5,0,0};
        int[] arr4 = new int[]{4,5,6,7,9};


        System.out.println(IsContinuous.isContinuous(arr4));
        /*System.out.println(IsContinuous.isContinuous(arr2));
        System.out.println(IsContinuous.isContinuous(arr3));*/
        /*
            true
            true
            false
         */


    }
}
