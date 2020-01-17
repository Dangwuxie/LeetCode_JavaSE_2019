package dxc.no13_机器人的运动范围;

/**
 * @author dxc
 * @Title: MovingRange
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/16 17:56
 */
public class MovingRange {

    public static int movingRange(int[][] matrix ,int k){
        if (matrix == null || matrix.length == 0 || k == 0){
            return -1;
        }
        //默认每个元素为false
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = movingRangeCore(matrix,matrix.length,matrix[0].length,0,0,visited,k);

        return count;
    }

    private static int movingRangeCore(int[][] matrix,int rows,int cols,
                                       int row,int col,boolean[][] visited,int k){

        int count = 0;

        if (check(matrix,rows,cols,row,col,visited,k)){
            //说明当前的格子可以进入
            visited[row][col] = true;
            //下面就是往下递归
            //此时count已经等于1；
            count = 1 + movingRangeCore(matrix,rows,cols,row-1,col,visited,k)
                    + movingRangeCore(matrix,rows,cols,row,col-1,visited,k)
                    + movingRangeCore(matrix,rows,cols,row+1,col,visited,k)
                    + movingRangeCore(matrix,rows,cols,row,col+1,visited,k);
        }

        return count;
    }
    //检测当前的格子是不是大于k了
    private static boolean check(int[][] matrix,int rows,int cols,
                                 int row,int col,boolean[][] visited,int k){

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getSum(row)+getSum(col) <= k
                && !visited[row][col]){
            return true;
        }

        return false;
    }

    private static int getSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}






