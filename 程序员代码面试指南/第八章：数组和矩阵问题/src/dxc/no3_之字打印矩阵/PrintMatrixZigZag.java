package dxc.no3_之字打印矩阵;

/**
 * @author 灵魂编程者
 * @Title: PrintMatrixZigZag
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 9:36
 */

/*
* 思路：两个初始点都是(0,0),不过t是走的是上右的路线，d走的是左下的路线
* 加上个标志，每一层遍历后，反过来继续输出
*
* */
public class PrintMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        boolean direction = true;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;

        //卡好截至条件，就是当上右的坐标遍历到右下角的时候停止输出
        while (tr!=endR+1){
            printLevel(matrix,tr,tc,dr,dc,direction);
            /*
            * t用右边界卡
            * d用下边界卡
            * */
            tr = tc==endC?tr+1:tr;
            tc = tc==endC?tc:tc+1;//此处也一样，修改判定条件应该是在后面
            //注意这四行代码的顺序，
            //t先判断行再判断列
            //d先判断列再判断行
            System.out.println(dr+"--"+dc);
            //注意这里的顺序，应该先判断dc，因为dc的值是根据dr==endR来判断的
            //如果先判断dr，当上一次dr==1，是，本次进来先加成2，此时等于endR了
            //dc就要开始加了，就错过了（2，0）直接变成(2,1);注意顺序；
            //每次根据上次的dr来优先更改dc的值，判定条件是dr，
            //所以每次修改判定值应该是在所有判定条件的后面
            dc = dr==endR?dc+1:dc;
            dr = dr==endR?dr:dr+1;

            //改变方向打印
            direction = !direction;
        }
    }

    public static void printLevel(int[][] matrix,int tr,int tc,int dr,int dc,boolean direction){
        if (direction){
            //按照某个方向打印
            while (tr!=dr+1){
                System.out.print(matrix[tr++][tc--]+" ");
            }
            System.out.println();
        }else {
            //换个方向打印
            while (dr!=tr-1){
                System.out.print(matrix[dr--][dc++]+" ");
            }
            System.out.println();
        }
    }
}
