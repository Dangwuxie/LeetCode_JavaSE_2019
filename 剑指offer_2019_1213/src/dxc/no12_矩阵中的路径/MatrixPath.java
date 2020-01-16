package dxc.no12_矩阵中的路径;

/**
 * @author dxc
 * @Title: MatrixPath
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/15 17:51
 */

/*
*
* */
public class MatrixPath {

    public static boolean matrixPath(char[][] matrix,char[] strs){
        if (matrix == null || matrix.length == 0 || strs == null){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        //用来表示是不是已经进入过该格子
        boolean[][] visited = new boolean[rows][cols];
        //pathLength用来标识当前的长度
        int pathLength = 0;
        for (int row = 0;row < rows; row++){

            for (int col = 0;col < cols; col++){
                if (hasPathCore(matrix,rows,cols,row,col,strs,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] matrix,int rows,int cols,
                                       int row,int col,char[] strs,int pathLength,boolean[][] visited){
        if (pathLength == strs.length){
            return true;
        }

        boolean hasPath = false;
        //此时就需要开始判断了
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == strs[pathLength]
                && !visited[row][col]){
            //在此if语句里面找它的四周四个格子的元素是不是strs中的下一个字符
            ++pathLength;
            //当前的格子已经走过了
            visited[row][col] = true;

            hasPath = hasPathCore(matrix,rows,cols,row,col-1,strs,pathLength,visited)
                    || hasPathCore(matrix,rows,cols,row-1,col,strs,pathLength,visited)
                    || hasPathCore(matrix,rows,cols,row,col+1,strs,pathLength,visited)
                    || hasPathCore(matrix,rows,cols,row+1,col,strs,pathLength,visited);
            //如果存在下一个，那么此时hasPath就是true
            if (!hasPath){
                --pathLength;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }
}
