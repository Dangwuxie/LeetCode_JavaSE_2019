package dxc.真题564_依次增大的整数数组找出所有元素等于下标的i;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 灵魂编程者
 * @Title: FindI
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 21:33
 */
/*
* 思路：
* 举个例子，最简单的方法就是遍历数组找就行；下
* 简单一点的方法：
* 例子：观察下面的例子，会发现，第二层为下标，我们可以发现，
* 当元素大于下标的时候，下标想要追上元素的值，中间的两个元素肯定是也小于该元素值的
* 就是说如果a[i]>i,那么接下来a[i]-i-1个元素也是肯定小于啊a[i]的，
* 所以此处可以用来简略一下遍历数组的次数的
* 7 8 9 10（7 7 7 7）
* 4 5 6 7 （4 5 6 7）
* */
public class FindI {
    public static ArrayList<Integer> findi(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0;i<arr.length;i++){
            if (arr[i] == i){
                list.add(i);
            }else if (arr[i]>i){
                i+=(arr[i]-i-1);
            }
        }
        return list;
    }
}
