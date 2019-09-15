package dxc.真题561_磁盘分区;

/**
 * @author 灵魂编程者
 * @Title: Allocable
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 20:48
 */
/*
* p={x1,x2,x3,x4...},q={y1,y2,y3,y4...},
* 将q数组中的每个元素（分区）挨个给p中的元素(磁盘)里面装，
* 如果当前磁盘剩余空间不够，则直接跳到下一个磁盘里面分区，
* 如果p里面的元素可以这样装下q里面的元素，就true，否则false
* */
/*
* 思路：遍历分区数组，循环里面判断，当前的磁盘剩余空间是否可以添加分区，
* 如果不能放下此分区并且还有空的磁盘，就遍历下一个磁盘，否则返回false；
* 如果磁盘下标index已经达到了磁盘的数量，那么就不能分区了，直接返回false；
* */
public class Allocable {
    public static boolean is_allocable(int[] p,int[] q){
        int index = 0;//此下标代表磁盘的下标，如果当前的磁盘剩余空间不够了，就要遍历下一个磁盘
        //遍历分区q
        for (int i=0;i<q.length;i++){
            //找合适的磁盘
            if (q[i]>p[index]&&index<p.length)
                index++;
            if (index >= p.length) return false;

            //下面就是将分区加进磁盘里面了
            p[index]-=q[i];
        }
        return true;
    }
}
