package dxc.no11_旋转数组的最小数字;

/**
 * @author dxc
 * @Title: GetMin
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/15 11:29
 */
/*
* 题目要求，将一个数组最开始的若干个元素搬移到数组的末尾，
* 称之为数组的旋转。
* 我们此时输入一个递增排序的数组的一个旋转，要求输出该旋转数组的最小值
* 比如，{1,2,3,4,5}
* {3,4,5,1,2}
* 最小值是1；
* */
public class GetMin {
    /*
    * 解决方法，最简单的方法是直接遍历一遍，时间复杂度为O(n)
    * 我们可以利用二分查找法实现O(logN)的时间复杂度
    * 可以设定两个之中p1\p2,分别指向数组第一个元素和最后一个元素，
    * 我们知道，当前的数组应该是两个小的递增数组的组合；
    * 首先我们知道p1肯定大于或者等于p2指向的元素
    * 每次找两个指针中间的下标的元素，
    * 这个元素要么小于p2，在后面的小数组里面，
    * 要么大于p1，在前面的小数组里面
    * 如果在前面的小数组里面，那么此时最小值肯定在后面，p1移动到当前的中心下标处；
    * 如果在后面的小数组里，此时最小值肯定在中心下标前面的数组里面，p2移动到当前的下标处，
    * */
    public static int getMin(int[] arr){

        if (arr == null || arr.length == 0){
            try {
                throw new Exception("输入错误！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int p1 = 0;
        int p2 = arr.length - 1;
        int indexMid = p1;//防止旋转前0个元素的出现

        while (arr[p1] >= arr[p2]){
            //当p1指向第一个子数组的最后一个元素
            //p2指向第二个子数组的最后一个元素的时候
            //p2就是最小的元素
            if (p2 - p1 == 1){
                return arr[p2];
            }

            /*
            * 注意，如果此时三个指针指向的三个数字都相同，就只能顺序遍历来解决问题了；
            * */

            indexMid = (p1 + p2) / 2;
            if (arr[indexMid] >= arr[p1]){
                p1 = indexMid;
            }else if (arr[indexMid] <= arr[p2]){
                p2 = indexMid;
            }
        }

        return arr[indexMid];
    }
}
