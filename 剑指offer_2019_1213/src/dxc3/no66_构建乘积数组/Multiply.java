package dxc3.no66_构建乘积数组;

/**
 * @author dxc
 * @Title: Multiply
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/26 15:50
 */
public class Multiply {

    public static void multiply(int[] arr1,int[] arr2){

        int len1 = arr1.length;
        int len2 = arr2.length;

        if (len1 == len2 && len2 > 1){
            arr2[0] = 1;
            int tmp = 1;
            for (int i = 1;i < len1; i++){
                tmp *= arr1[i-1];
                arr2[i] = tmp;
            }

            tmp = 1;
            for (int i = len1 - 2;i >= 0; i--){
                tmp *= arr1[i+1];
                arr2[i] *= tmp;
            }

            /*arr2[0] = 1;
            for (int i = 1;i < len1; i++){
                arr2[i] = arr2[i-1] * arr1[i-1];
            }

            int tmp = 1;
            for (int i = len1-2;i >= 0; i--){
                tmp *= arr1[i+1];
                arr2[i] *= tmp;
            }*/
        }


    }

}
