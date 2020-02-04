package dxc.no29_顺时针打印矩阵;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 21:52
 */
public class Test {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3,4},
                {6,7,8,9},
                {11,12,13,14},
                {16,17,18,19},
                {21,22,23,24}
        };
        int[][] matrix2 = {
                {1,1,1,1,1,1},
                {2,2,2,2,2,2},
                {3,3,3,3,3,3}
        };
        int[][] matrix3 = {
                {1,1,1},
                {2,2,2},
                {3,3,3},
                {4,4,4},
                {5,5,5},
                {6,6,6}
        };
        int[][] matrix4 = {
                {1,1,1},
                {2,2,2},
                {3,3,3},
        };

        PrintMatrixInCircle.printMatrixInCircle(matrix);
    }
}
