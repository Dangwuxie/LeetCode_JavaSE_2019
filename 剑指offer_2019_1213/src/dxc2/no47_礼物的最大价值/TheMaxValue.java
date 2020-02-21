package dxc2.no47_礼物的最大价值;

/**
 * @author dxc
 * @Title: TheMaxValue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/19 19:46
 */
/*
*
* */
/*
* 需要额外的一个数组，长度是矩阵的列数；
* 因为它每个格子的最大值取决于左、上两个格子；
* 所以可以用一个类似于滑动窗口的数组，
* 来一层一层的遍历；
* */
public class TheMaxValue {

    public static int getMaxValue(int[][] matrix){

        if (matrix == null || matrix.length == 0){
            return 0;
        }

        int[] cols = new int[matrix[0].length];

        for (int i = 0;i < matrix.length; i++){

            for (int j = 0;j < matrix[0].length; j++){
                int up = 0;
                int left = 0;

                if (j > 0){
                    left = cols[j - 1];
                }

                if (i > 0){
                    up = cols[j];
                }

                cols[j] = Math.max(left,up) + matrix[i][j];
            }
        }

        return cols[matrix[0].length - 1];
    }
}










