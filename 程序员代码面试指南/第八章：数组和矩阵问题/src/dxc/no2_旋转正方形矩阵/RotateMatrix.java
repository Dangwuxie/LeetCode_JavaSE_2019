package dxc.no2_旋转正方形矩阵;

import dxc.no1_转圈打印矩阵.SpiralOrderPrint;

/**
 * @author 灵魂编程者
 * @Title: RotateMatrix
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/14 21:32
 */
/*
* 依旧是分圈处理的思想，m*m的矩阵，m-1组需要调换的数字
* 例如1234，5678，9101112，13141516；
* 第一圈，三组，1-4-16-13，2-8-15-9，3-12-14-5
*
*
* */
public class RotateMatrix {
    public static void rotateMatrix(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length-1;
        int dc = matrix[0].length-1;

        while (tr<dr){
            rotatePrint(matrix,tr++,tc++,dr--,dc--);
        }
        //调用前面的转圈打印矩阵
        SpiralOrderPrint.spiralOrderPrint(matrix);
    }


    public static void rotatePrint(int[][] matrix,int tr,int tc,int dr,int dc){
        int times = dc-tc;//每一圈数字交换的组数
        /*
        * 此时就需要按照这种方式交换数字
        * 1-4-16-13，2-8-15-9，3-12-14-5
        * */
        for (int i=tc;i<times;i++){
            //交换数字
            int temp = matrix[tr][i];
            matrix[tr][i] = matrix[dr-i][tc];
            matrix[dr-i][tc] = matrix[dr][dc-i];
            matrix[dr][dc-i] = matrix[i][dc];
            matrix[i][dc] = temp;
        }
    }
}
