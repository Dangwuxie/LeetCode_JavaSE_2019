package dxc.no9_求最大子矩阵的大小;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/1 23:44
 */


public class Test {

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,1,1,1,1},
                            {1,0,1,1,0},
                            {0,1,0,1,1}
                        };
        int max = MaxMatrix.findMaxArea(matrix);
        System.out.println(max);

    }
}
