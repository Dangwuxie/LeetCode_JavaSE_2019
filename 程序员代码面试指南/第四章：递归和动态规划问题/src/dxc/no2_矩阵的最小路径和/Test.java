package dxc.no2_矩阵的最小路径和;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/18 14:32
 */
public class Test {

    public static void main(String[] args) {
        int[][] m = new int[][]{
            {1,3,5,9},
            {8,1,3,4},
            {5,0,6,1},
            {8,8,4,0}
        };

        System.out.println(MatrixMinPathSum.matrixMinPathSum(m));

    }
}
