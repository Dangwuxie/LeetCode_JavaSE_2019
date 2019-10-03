package dxc.no9_求最大子矩阵的大小;

import dxc.PrintArray;

import java.util.Stack;

/**
 * @author 灵魂编程者
 * @Title: MaxMatrix
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/10/3 0:15
 */

/*
* 题目：求最大子矩阵：给定一个整形矩阵，其中的元素只有0和1，
* 求全是1的区域中最大的子矩阵；
* 例1：{1,1,1,0}子矩阵是{1，1，1}，所以此时返回3
* 例2：{
*        {1，0，1，1}
*        {1，1，1，1}
*        {1，1，1，0}
*      }
*  最大矩形区域为6个1，返回6；
*
*   思路：可以定义一个数组marge，一层一层的遍历，保存连续出现的1的个数
*   就拿上面的矩阵来说：
*   marge[0] = {1,0,1,1}
*   marge[1] = {2,1,2,2}
*   marge[2] = {3,2,3,0} //注意，如果某一层的某一列碰到0，那么就相当于不连续了
*   此时我们可以把每个数看成一个矩形，四个矩形看出条形图那样
*   然后就是求条形图最大的能拼起来的矩阵的面积，
*   上面的例子中三层的面积最大分别为2，4，6；
*   我们发现，最大面积就是求出每一个矩阵的高度向两边扩展到不能扩展为止，
*   然后计算扩展后的面积，那么如何找到扩展的边界呢
*   所以此时可以利用单调递增的栈来实现，单调栈，
*   可以求出当前数组中遍历到的元素的两边离他最近并且比它小的数
*   这恰好就是当前的高度所能求得的最大面积
*
* */
public class MaxMatrix {

    public static int findMaxArea(int[][] matrix) {
        int maxLevleArea = 0;

        int[] merge = new int[matrix[0].length];
        //下面就是一层一层的遍历
        int len = matrix[0].length;

        for (int i=0;i<matrix.length;i++){

            //嵌套for循环，计算merge的元素值
            for (int j=0;j<len;j++){
                //刷新merge数组的值
                merge[j] = matrix[i][j]==0?0:(merge[j]+1);
            }
            //求出maxLevelArea的最大值
            maxLevleArea = Math.max(maxArea(merge),maxLevleArea);

        }

        //最后返回这个最大面积的值
        return maxLevleArea;
    }

    public static int maxArea(int[] merge){

        int maxArea = 0;
        //利用一个单调递增的栈，找出merge数组中每一个元素两边离它最近的比它小的元素；
        Stack<Integer> stack = new Stack<>();

        int j = -1;
        int k = -1;

        for (int i=0;i<merge.length;i++){

            //利用栈找出两边的min下标，然后计算面积
            //i代表当前遍历的rightIndex
            //j代表当前弹出的元素
            //k代表弹出后的栈顶元素，就是leftIndex
            while (!stack.isEmpty() && merge[i]<=merge[stack.peek()]){
                k = -1;
                //此时就是计算当前弹出的j所在的矩形朝两边扩展出来的面积
                j = stack.pop();
                if (!stack.isEmpty()){
                    k = stack.peek();
                }

                //左边的是k+1，右边的是i-1，但是计算公式是i-k-1,画个图就能看明白了
                int areaTmp = (i-k-1)*merge[j];

                maxArea = Math.max(areaTmp,maxArea);
            }
            stack.push(i);
        }
        //此时栈中肯定还存在没有弹出的元素，此时也需要计算
        //假设此时遍历到下标6，6处的元素是极小的，所以需要弹出此元素
        //计算面积的时候使用i =6计算即可
        while (!stack.isEmpty()){

            j = stack.pop();
            if (!stack.isEmpty()){
                k = stack.peek();
            }
            int i = merge.length;
            int areaTmp = (i-k-1)*merge[j];

            maxArea = Math.max(areaTmp,maxArea);

        }
        return maxArea;
    }
}
