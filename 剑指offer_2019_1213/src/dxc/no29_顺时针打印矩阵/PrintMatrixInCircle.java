package dxc.no29_顺时针打印矩阵;

/**
 * @author dxc
 * @Title: PrintMatrixInCircle
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/2 22:06
 */
/*
* 从外向里以顺时针的顺序打印出矩阵
* */
public class PrintMatrixInCircle {

    /*
    * 思路：左上角和右下角两个点卡边界值，然后两个坐标往内层靠拢
    * 每次需要判断两个坐标是否移动到同一行或者同一列，
    * 此时就是最后一组数字了；
    * */
    public static void printMatrixInCircle(int[][] matrix){

        if (matrix == null){
            return;
        }

        int r1 = 0;//左上角
        int c1 = 0;
        int r2 = matrix.length-1;//右下角
        int c2 = matrix.length-1;

        while (c1 <= c2 && r1 <= r2){
            printMatrixCore(matrix,r1,c1,r2,c2);
            r1++;c1++;r2--;c2--;
        }

    }

    private static void printMatrixCore(int[][] matrix,int r1,int c1,int r2,int c2){
        //每次进来都要判断是不是到最后一行或者最后一列了，要特殊处理
        if (r1 == r2){
            //一行了
            for (int i = c1;i <= c2; i++){
                System.out.print(matrix[r1][i] + "-");
            }
        }else if (c1 == c2){
            for (int i = r1;i <= r2; i++){
                System.out.print(matrix[i][c1] + "-");
            }
        }else {
            //此时就是说还可以饶一圈
            int curR = r1;//临时左上角遍历节点
            int curC = c1;
            //上,此时C右移，R不变
            while (curC < c2){
                System.out.print(matrix[r1][curR]+"-");
            }
            //右;
            while (curR < r2){
                System.out.print(matrix[curR][c2]+"-");
            }
            //下,此时curC刚好就等于c2
            while (curC > c1){
                System.out.print(matrix[r2][curC]+"-");
            }
            //左，此时curR刚好就等于r2
            while(curR > r1){
                System.out.print(matrix[curR][c1]+"-");
            }
        }



    }
}
