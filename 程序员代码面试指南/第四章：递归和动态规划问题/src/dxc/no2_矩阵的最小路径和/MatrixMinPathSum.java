package dxc.no2_矩阵的最小路径和;

/**
 * @author 灵魂编程者
 * @Title: MatrixMinPathSum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/18 22:08
 */

/*
* 题目：给定一个矩阵，从左上角开始走，每次只能走右或者下
* 最后到达右下角的为止，路径上的数字累加起来就是路径和
* 求最小的路径和；
* */
public class MatrixMinPathSum {

    /*
    * 解法1：书上说的是倒退着从右下角反着找最小路径和
    * 咱们也反着来吧，正着来不好表达，
    * 思路：从最右下角开始，除去第一行跟第一列，剩余的
    * 点的来路要么是从它上面来，要么就是从左边来，
    * 所以我们只需要求出矩阵m[i-1][j]和m[i][j-1]哪个点
    * 到m[i][j]的路径和最小，就选哪个；再依次倒推就行；
    * 这样我们可以写出另外一个矩阵，就是它的最短路径和矩阵
    * 原矩阵中左、上，哪个点到当前点的路径和最小就写最小的那个值
    * 一路写下去，最后那个最右下角的值就是所要求的最短路径和；
    *
    * 时间复杂度O(m*n),空间复杂度O(m*n)
    * */
    public static int matrixMinPathSum(int[][] m){
        //首先对二维数组的判空
        if (m == null || m.length == 0 || m[0] == null | m[0].length == 0){
            return 0;
        }

        int row = m.length;
        int col = m[0].length;
        int[][] tmpMatrix = new int[row][col];
        //[0][0]元素，两个矩阵是相等的；
        tmpMatrix[0][0] = m[0][0];

        //下面是对临时矩阵第一行跟第一列的计算
        for (int i = 1;i < col; i++){
            tmpMatrix[0][i] = tmpMatrix[0][i-1]+m[0][i];
        }
        for (int j = 1;j < row; j++){
            tmpMatrix[j][0] = tmpMatrix[j-1][0] + m[j][0];
        }

        //下面是对中间的点的路径和的计算
        for (int i = 1;i < row; i++){
            for (int j = 1;j < col; j++){
                tmpMatrix[i][j] =
                        Math.min(tmpMatrix[i-1][j]+m[i][j],tmpMatrix[i][j-1]+m[i][j]);
            }
        }
        //最后返回”路径和“矩阵的最右下角的值
        return tmpMatrix[row-1][col-1];
    }

    /*
    * 方法2：此方法的时间复杂度不变，额外空间复杂度变成O(min{M,N}),
    * 实现思路：利用滚动数组，不断更新的方式
    * 比如使用大小为N的数组arr，从第一行开始一行一行的往下滚动
    * arr[0]-arr[N-1]的值是依次累加的值
    * 从第二行开始,
    * arr[0]=m[0][0]+m[1][0],
    * arr[1]=min{arr[0],arr[1]}+m[1][1]
    * 然后依次类推；数组滚动直到最后一行
    * */
    public static int matrixMinPathSum2(int[][] m){

        //首先对二维数组的判空
        if (m == null || m.length == 0 || m[0] == null | m[0].length == 0){
            return 0;
        }

        int max = Math.max(m.length,m[0].length);
        int min = Math.min(m.length,m[0].length);
        int[] arr = new int[min];
        boolean bigrow = m.length == max;
        arr[0] = m[0][0];

        for (int i = 1;i < min; i++){
            arr[i] = arr[i-1] + (bigrow ? m[0][i] : m[i][0]);
        }

        //下面开始滚动
        for (int i = 1;i < max; i++){
            arr[0] = arr[0] + (bigrow ? m[i][0] : m[0][i]);
            for (int j = 1;j < min; j++){
                arr[j] = Math.min(arr[j-1],arr[j])
                        + (bigrow ? m[i][j] : m[j][i]);
            }
        }

        //最后返回arr[min-1]
        return arr[min-1];
    }
}
