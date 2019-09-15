package dxc.no3_之字打印矩阵;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 9:34
 */


public class Test {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        PrintMatrixZigZag.printMatrixZigZag(matrix2);
    }
}
