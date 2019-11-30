package dxc.no7_在行列都排好序得矩阵中找指定数;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/30 23:10
 */

public class Test {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {13,15,17,19},
                {22,23,24,26},
                {32,34,37,38},
                {41,42,44,49},
                {51,53,54,57}
        };

        System.out.println(IsContains.isContains(matrix,43));

    }
}
