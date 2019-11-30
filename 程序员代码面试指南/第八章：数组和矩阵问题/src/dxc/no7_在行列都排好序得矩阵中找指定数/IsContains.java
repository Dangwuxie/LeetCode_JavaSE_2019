package dxc.no7_在行列都排好序得矩阵中找指定数;

/**
 * @author 灵魂编程者
 * @Title: IsContains
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/30 23:10
 */

/*
* 题目：在行跟列都已经排好序的情况下判断给定的一个数是否在矩阵中；
* 要求时间复杂度为O(N+M),额外空间复杂度为O(1);
*
* 思路：很简单，因为行列已经排好序，可以直接从右上角，或者左下角找起
* 当matrix当前元素比k大时，col--，因为当前列下面的元素都是比k大的
* 当matrix当前元素比k小时，row++，因为当前行左边的元素肯定比k都小，
* */
public class IsContains {

    public static boolean isContains(int[][] matrix,int k){

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col > -1){
            if (matrix[row][col] == k){
                return true;
            }else if (matrix[row][col] > k){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
