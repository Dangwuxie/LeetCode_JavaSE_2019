package dxc.no6_在其他数都出现k次的数组中找到只出现一次的数;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/27 22:30
 */
public class Test {

    public static void main(String[] args) {
        /*int[] res = new int[32];
        int k = 39;
        int index = 0;

        while (k != 0){
            res[index++] = k % 2;
            k = k/2;
        }

        for (int cur : res){
            System.out.print(cur+" ");
        }*/

        int[] arr = new int[]{
                5,5,5,5,
                3,3,3,3,
                6,6,6,6,
                7,7,7,7,
                6};
        System.out.println(CountNum.countNum(arr,4));
    }
}
