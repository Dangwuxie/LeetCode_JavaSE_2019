package dxc.no4_二维数组中的查找;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/15 22:03
 */
public class Test {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        System.out.println(MatrixFindK.matrixFindK1(matrix,7));
        System.out.println(MatrixFindK.matrixFindK1(matrix,1));
        System.out.println(MatrixFindK.matrixFindK1(matrix,15));
        System.out.println(MatrixFindK.matrixFindK1(matrix,5));
        System.out.println(MatrixFindK.matrixFindK1(matrix,16));
        System.out.println(MatrixFindK.matrixFindK1(matrix,-4));
        System.out.println("----------------------------------");
        System.out.println(MatrixFindK.matrixFindK2(matrix,7));
        System.out.println(MatrixFindK.matrixFindK2(matrix,1));
        System.out.println(MatrixFindK.matrixFindK2(matrix,15));
        System.out.println(MatrixFindK.matrixFindK2(matrix,5));
        System.out.println(MatrixFindK.matrixFindK2(matrix,16));
        System.out.println(MatrixFindK.matrixFindK2(matrix,-4));
    }
}
