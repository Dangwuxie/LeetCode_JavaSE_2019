package dxc.no12_矩阵中的路径;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/15 17:51
 */
public class Test {

    public static void main(String[] args) {
        char[][]  matrix = new char[][]{
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };
        char[][] matrix2 = null;
        char[] strs1 = new char[]{'a','b','f','d','e','c','s'};
        char[] strs2 = new char[]{'a','b','f','d','e','c','h'};
        char[] strs3 = new char[]{'a','c','j'};
        char[] strs4 = new char[]{'a','b','t','g'};
        char[] strs5 = null;

        System.out.println(MatrixPath.matrixPath(matrix,strs1));
        System.out.println(MatrixPath.matrixPath(matrix,strs2));
        System.out.println(MatrixPath.matrixPath(matrix,strs3));
        System.out.println(MatrixPath.matrixPath(matrix,strs4));
        System.out.println(MatrixPath.matrixPath(matrix,strs5));
        /*
        *
            true
            false
            true
            true
            false
        * */
    }
}
