package dxc.no8_单调栈结构;

/**
 * @author 灵魂编程者
 * @Title: MinIndex1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/29 23:04
 */

/*
* 题目要求：给你一个数组，让你从第一个元素开始，
* 用一个二维数组，每一行两个数字，保存在当前元素两边离他最近的比它小的元素
* 例子：arr={3,4,1,5,6,2,7}
* 返回的二维数组就是：
* {
*     {-1.2}
*     {0,2}
*     {-1,-1}
*     {2,5}
*     {3,5}
*     {2,-1}
*     {5,-1}
* }
*
* */

/*
*   首先实现时间复杂度为O(N^2)的代码，
*   这种复杂度也就是我们最先想到的方法，for循环，然后每次以当前位置为起点，
*   左右遍历，找到第一个小于i元素的就停，赋值就行；
* */
public class MinIndex1 {

    public static int[][] findMinIndex(int[] arr){
        int[][] res = new int[arr.length][2];

        for (int i=0;i<arr.length;i++){
            int cur = i-1;
            //-1的意思就是说如果左边或者右边没有比当前元素小的值，此下标就是-1
            int leftMinIndex = -1;
            int rightMinIndex = -1;

            //当前的元素是i，但是i从1开始才可以找左边的min，所以直接从i=1开始判断就行
            //先找左边的
            while (cur>=0){
                if (arr[cur] < arr[i]){
                    leftMinIndex = cur;
                    break;
                }
                cur--;
            }

            //然后找右边的离的最近的min数，记下坐标
            cur = i+1;
            while (cur<arr.length){
                if (arr[cur] < arr[i]){
                    rightMinIndex = cur;
                    break;
                }
                cur++;
            }

            res[i][0] = leftMinIndex;
            res[i][1] = rightMinIndex;

        }

        return res;
    }

}


























