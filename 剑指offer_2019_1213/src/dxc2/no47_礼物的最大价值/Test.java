package dxc2.no47_礼物的最大价值;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/19 19:41
 */
public class Test {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,1},
                {3,7,16,5}
        };

        System.out.println(TheMaxValue.getMaxValue(matrix));

    }
}
