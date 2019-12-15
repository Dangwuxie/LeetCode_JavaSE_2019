package dxc.no4_二维数组中的查找;

/**
 * @author dxc
 * @Title: MatrixFindK
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/15 22:06
 */

/*
* 题目要求：给定一个二维数组matrix和一个整数k，查找矩阵中是否存在这个整数
* 这个矩阵的行和列都是一次递增的；从左到右，从上到下；
* */
public class MatrixFindK {
    /*
    * 实现思路：从右上角或者左下角开始一行或者一列的排除法；
    * 假设matrix={
    *               1,2,8,9
    *               2,4,9,12
    *               4,7,10,13
    *               6,8,11,15
    *           }
    * k=7;
    * 不能从左上角或者右下角开始排除，比如从左上角开始
    * 7>1,但是1的右边和下边都是比1大的，无法排除1所在行和列，所以无法排除；
    * */

    /*
    * 首先从右上角开始排除
    * */
    public static boolean matrixFindK1(int[][] matrix,int k){
        boolean find = false;
        int row = 0;
        int col = matrix[0].length-1;

        if (matrix != null){

            while (row != matrix.length && col != -1){
                if (matrix[row][col] == k){
                    find = true;
                    break;
                }else if (matrix[row][col] > k){
                    col--;
                }else {
                    row++;
                }
            }
        }
        return find;
    }
    /*
    * 从左下方开始
    * */

    public static boolean matrixFindK2(int[][] matrix,int k){
        boolean find = false;
        int row = matrix[0].length-1;
        int col = 0;

        if (matrix != null){

            while (row != -1 && col != matrix[0].length){

                if (matrix[row][col] == k){
                    find = true;
                    break;
                }else if (matrix[row][col] > k){
                    row--;
                }else {
                    //那么就是当前矩阵中的数字小于k，那么当前数字所在的列就可以排除了
                    col++;
                }
            }

        }
        return find;
    }
}
