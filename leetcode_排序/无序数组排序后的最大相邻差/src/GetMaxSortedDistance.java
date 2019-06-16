
/**
 * @author Dangxuchao
 * @Title: GetMaxSortedDistance
 * @ProjectName leetcode_排序
 * @Description: 求一个无序数组排序后的最大相邻差值；
 * 思路，利用桶排序的思想，实现时间复杂度为O(n)的运算，
 *
 * @date 2019/6/16 10:44
 */
public class GetMaxSortedDistance {
    /**
     * 桶；
     */
    private static class Bucket{
        Integer max;
        Integer min;
    }
    public static int getMaxSortedDistance(int[] array){
        //1.首先得到数列中的最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1;i < array.length;i++){
            if (max < array[i]){
                max = array[i];
            }
            if (min > array[i]){
                min = array[i];
            }
        }
        int d = max - min;
        //如果max和min相等，说明数组所有元素都相等，直接返回0；
        if (d == 0){
            return 0;
        }

        //2.初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0;i < bucketNum;i++){
            buckets[i] = new Bucket();
        }

        //3.遍历原始数组，确定每个桶的最大最小值
        for (int i = 0;i < array.length;i++){
            //这一步是求出元素所所归属桶中的下标

            float temp =  (bucketNum - 1)/(float)d;
            int bucketIndex = (int) ((array[i] - min) *temp);

            //int bucketIndex = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[bucketIndex].max == null || buckets[bucketIndex].max < array[i]){
                buckets[bucketIndex].max = array[i];
            }
            if (buckets[bucketIndex].min == null || buckets[bucketIndex].min > array[i]){
                buckets[bucketIndex].min = array[i];
            }
        }
        /**
         * 4.每个桶已经赋值完毕了，下面就是求最大间距了
         *  先定义一个保存最大间距的变量maxDistance
         *  遍历所有的桶，统计出每一个桶的最大值，和这个桶右侧非空桶的最小值的差，
         *  数值最大的差就是原数组排序后的相邻最大差值；
         */
        int a = 0;
        int b = 0;
        int maxDistance = 0;
        int leftMax = buckets[0].max;
        for (int i = 1;i < buckets.length;i++){
            if (buckets[i].min == null){
                continue;
            }
            if (maxDistance < buckets[i].min - leftMax){
                maxDistance = buckets[i].min - leftMax;
                a = buckets[i].min;
                b = leftMax;
            }
            leftMax = buckets[i].max;
        }
        //System.out.println(a+" "+b);

        for (int i = 1;i < buckets.length;i++){
            System.out.println(buckets[i].min+" "+buckets[i].max);
        }
        //循环结束后返回最后保存的maxDistance，即最大间距；
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,6,9,1};
        System.out.println("排序后的最大间隔为："+getMaxSortedDistance(array));

    }
    /**
     * 运行结果：
     *
     * 6 6
     * null null
     * 9 9
     * 排序后的最大间隔为：3
     */
}
