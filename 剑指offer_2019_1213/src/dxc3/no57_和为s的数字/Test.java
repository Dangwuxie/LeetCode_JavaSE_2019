package dxc3.no57_和为s的数字;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/22 14:35
 */
public class Test {

    public static void main(String[] args) {

        /*int[] arr = new int[]{1,2,4,7,8,11,15};
        TwoNumberOfSumIsK.findTwoNumbers(arr,15);*/

        int sum = 19;
        for (int i = 9;i < 20; i++){
            System.out.println("sum = "+i+":");
            SumIsSOfSequence.getSequence(i);
            System.out.println("------------------");
        }

        /*
            sum = 9:
            2-3-4-
            4-5-
            ------------------
            sum = 10:
            1-2-3-4-
            ------------------
            sum = 11:
            5-6-
            ------------------
            sum = 12:
            3-4-5-
            ------------------
            sum = 13:
            6-7-
            ------------------
            sum = 14:
            2-3-4-5-
            ------------------
            sum = 15:
            1-2-3-4-5-
            4-5-6-
            7-8-
            ------------------
            sum = 16:
            ------------------
            sum = 17:
            8-9-
            ------------------
            sum = 18:
            3-4-5-6-
            5-6-7-
            ------------------
            sum = 19:
            9-10-
            ------------------
        */

    }
}
