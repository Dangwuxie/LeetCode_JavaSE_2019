package dxc.no1_转圈打印矩阵;

/**
 * @author 灵魂编程者
 * @Title: SpiralOrderPrint
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/14 18:58
 */
/*
* 思路，矩阵分圈处理；两个坐标代表一圈矩阵，
* 比如（0,0）和(3,3),在4*4矩阵里面代表的是最外层的一圈，
* 每次根据这两个坐标，遍历二维矩阵的一圈，每遍历一次，左上角的坐标+1变成(1,1)
* 右下角的坐标-1变成(2,2),依次类推，直到左上角的坐标减到右下角坐标的右边，就停止遍历
*
*
* */
public class SpiralOrderPrint {

    public static void spiralOrderPrint(int[][] matrix){
        //此处是进行具体的每一圈的计算的
        int tr = 0;
        int tc = 0;//t开头代表左上的顶点

        int dr = matrix.length-1;
        int dc = matrix[0].length-1;//d开头代表右下角的顶点的坐标

        //然后是循环调用，当t没有到d的后面，就继续循环
        while (tr<=dr && tc<=dc){
            printEdge(matrix,tr,tc,dr,dc);
            tr++;tc++;dr--;dc--;
        }
    }

    public static void printEdge(int[][] matrix,int tr,int tc,int dr,int dc){
        //此处首先要判断，如果不是正方形的矩阵，那么可能会出现两个顶点坐标会出现在
        //同一列或者同一行的情况，所以此处首先需要进行判断
        if (tr==dr){
            for (int i=tc;i<=dc;i++){
                System.out.print(matrix[tr][i]+" ");
            }
        }else if (tc==dc){
            for (int i=tr;i<=dr;i++){
                System.out.print(matrix[i][tc]+" ");
            }
        }else {
            //正常遍历一圈子
            //定义两个临时遍历用来遍历矩阵
            int curR = tr;
            int curC = tc;
            //上
            while (curC<dc){
                System.out.print(matrix[tr][curC]+" ");
                curC++;
            }

            //右
            while (curR<dr){
                System.out.print(matrix[curR][dc]+" ");
                curR++;
            }

            while (curC>tc){
                System.out.print(matrix[dr][curC]+" ");
                curC--;
            }

            while (curR>tr){
                System.out.print(matrix[curR][tc]+" ");
                curR--;
            }
        }

    }
}
