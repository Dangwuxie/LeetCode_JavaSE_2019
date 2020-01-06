package dxc.no13_计算数组的小和;

/**
 * @author dxc
 * @Title: GetSmall
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/6 23:02
 */
/*
* 题目要求：给一个数组，要求输出每个元素左边小于它的所有元素的和
* 例子：arr=[1,3,4,2,5,6];
* 第一个是1，左边小于它的元素为0，小和就是0
* 第二个是3，左边的1小于它，小数和就是1
* 第三个是4，左边的1、3小于它，所以小数和是4
* 第四个是2，左边只有1，所以小数和是1
* 第五个是5，左边四个元素都小于它，小数和为10
* 第六个是6，小数和是15；
* 下面计算总数和，0+1+4+1+10+15=31；
* */
/*
* 解题思路，利用归并排序的思想，将时间复杂度从O(n^2)降到O(NlogN);
* 额外空间复杂度为O(N);
* O(N^2)的解题思路很简单，就是每次求出每个元素左边小于它的元素的和，最后汇总；
* O(N^2)的思路就是，归并的过程中比较，每次归并的过程都是左右两组之间的汇总
* 每次求得就是左组的元素小于右组第几个元素，右组的这个元素包括它本身在内右边有多少个元素
* 就计算和，最后汇总；需要额外空间O(N)；
* 逆向思维，由小数求右边大于它的元素的个数；
* [1,3,4]和[2,5,6]
* */
public class GetSmall {

    public static int getSmall(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return getC(arr,0,arr.length-1);
    }

    private static int getC(int[] s,int l,int r){
        if (l == r){
            return 0;
        }
        int mid = (r + l)/2;
        return getC(s,l,mid) + getC(s,mid+1,r) + merge(s,l,mid,r);
    }


    private static int merge(int[] s,int left,int mid,int right){
        //保存当前合并过程中产生的小和
        int smallSum = 0;
        int[] tempMerge = new int[right - left + 1];
        int i = 0;//记录tempMerge的下标
        int l = left;
        int r = mid+1;

        while (l <= mid && r <= right){
            //一遍合并一遍不停的记录小数和
            if (s[l] <= s[r]){
                //如果小于等于右边的数，那么直接加上r已经r右边的所有数字
                smallSum += (right-r+1) * s[l];
                tempMerge[i++] = s[l++];
            }else {
                tempMerge[i++] = s[r++];
            }
        }
        //上面的while循环结束之后，肯定r下标已经结束，此时还需要将l判断一下
        for (;l <= mid || r <= right;l++,r++){
            tempMerge[i++] = l > mid ? s[r] : s[l];
        }

        //额外的空间复杂度用来保存已经排序完成的元素数组
        //然后复制给原数组
        for (int k = 0;k < tempMerge.length; k++){
            s[left++] = tempMerge[k];
        }
        return smallSum;
    }
}
