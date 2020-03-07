package dxc3.no66_构建乘积数组;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/24 14:41
 */
public class Test {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[5];

        Multiply.multiply(arr1,arr2);

        for (int i: arr2){
            System.out.println(i);
        }
    }
}
