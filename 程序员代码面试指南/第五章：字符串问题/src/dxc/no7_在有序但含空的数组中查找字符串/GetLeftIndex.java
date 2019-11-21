package dxc.no7_在有序但含空的数组中查找字符串;

/**
 * @author 灵魂编程者
 * @Title: GetLeftIndex
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/11/21 11:06
 */

/*
* 题目要求：给一个字符串数组strs和一个字符串str，在数组中找出存在的str字符串
* 数组里面的字符串是按照字典顺序由小到大依次出现的;
* 如果没找到或者str是null，就返回-1；
* 如果找到了，就找最左边的那一个字符串,然后返回它的下标;
* */
public class GetLeftIndex {

    /*
    * 思路:利用二分查找，定义一个全局变量res保存每次寻找到相同字符串的下标
    * 每次与中间的元素mid对比，如果strs[mid]==str,记录此坐标，
    * 然后需要继续在左班部分继续寻找，如果strs[mid]==null,就找左半部分
    * 如果左半部分都是null，就去右半部分找，如果左半部分从右向左第一个字符串小于str
    * 就说明左半部分没有相等的了，如果整个数组都找不到对应字符串，就返回-1；
    *
    * */
    public static int getLeftIndex(String[] strs,String str){

        if (strs == null || strs.length == 0 || str == null){
            return -1;
        }

        int left = 0;
        int right = strs.length-1;
        int mid = 0;
        int i = 0;
        int res = -1;

        while (left <= right){
            mid = (left + right) / 2;

            if (strs[mid] != null && strs[mid].equals(str)){
                res = mid;
                right = mid-1;
            }else if (strs[mid] != null){
                //此时不为null，但是他也不等于str
                if (strs[mid].compareTo(str) < 0){
                    //小于str
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }

            }else {
                //此时就是mid的字符串是null的情况了
                i = mid;//i的作用就是遍历左半部分数组的
                while (strs[i] == null && --i >= left);
                //当while循环停止的时候，就是碰到字符串了，或者说左半部分全部都是null
                if (i < left || strs[i].compareTo(str) < 0){
                    //说明此时左半部分并没有相同的元素，因为左半部分最大的strs[i]已经小于strl
                    left = mid+1;
                }else {
                    res = strs[i].equals(str) ? i : res;
                    //说明此时第一个元素有比str大的，所以左半部分继续需要二分查找
                    right = mid-1;
                }

            }

        }

        return res;
    }
}
