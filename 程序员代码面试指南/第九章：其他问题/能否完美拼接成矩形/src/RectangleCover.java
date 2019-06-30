import java.util.HashSet;

/**
 * @author Dangxuchao
 * @Title: RectangleCover
 * @ProjectName 第九章：其他问题
 * @Description: TODO
 * @date 2019/6/30 18:22
 */
public class RectangleCover {
    public static void main(String[] args) {
        /*int[][] matrix = {
                {1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}
        };*/
        /*int[][] matrix = {
                {0,0,1,1},
                {0,1,1,2},
                {1,0,2,1},
                {1,1,2,2}
        };*/
        /*int[][] matrix = {
                {0,0,1,2},
                {0,0,2,3},
                {2,0,3,3}
        };*/
        int[][] matrix = {
                {0,0,1,1},
                {0,1,1,2},
                {1,0,2,3},
                {2,0,3,3}
        };
        System.out.println(isRectangleCover(matrix));
    }
    public static boolean isRectangleCover(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            //如果二维数组为0，
            return false;
        }
        //先定义出最大数组的四个边
        //每次求左下的最小值；
        int mostLeft = Integer.MAX_VALUE;
        int mostDown = Integer.MAX_VALUE;
        //每次求右上的最大值
        int mostRight = Integer.MIN_VALUE;
        int mostUp = Integer.MIN_VALUE;

        /*
        下面就是循环遍历二维数组中的每个小的矩形，
        遍历结束后会得到最大矩形的四个点的左边，以便计算面积；
        循环中将每次遍历的小矩形的面积综合用一个变量area存起来；
         */
        int area = 0;

        //集合存下重复坐标

        HashSet<String> set = new HashSet<>();

        for (int[] rect : matrix){
            //每次取一个小矩形进行计算；
            //求最大矩形的四个顶点；
            mostLeft = Math.min(rect[0],mostLeft);
            mostDown = Math.min(rect[1],mostDown);

            mostRight = Math.max(rect[2],mostRight);
            mostUp = Math.max(rect[3],mostUp);

            //然后累加小矩形的面积
            area += (rect[2]-rect[0])*(rect[3]-rect[1]);
            /*
            下面这操作可以说是非常有灵性了，为了后面的顶点判断做铺垫
            用HashSet集合存起来每个小矩形的顶点，偶数次的话刚好删除
            最终这个String集合里面就只剩下四个矩形的顶点坐标了，
            如果仅剩下顶点坐标，表示没有哪两个小矩形有重合区域，
            然后判断面积是否有残缺，是否相等就行了；
            使用String存下每个矩形的四个顶点坐标，以字符串的形式存入集合中
            四个顶点分别为左下，左上，右下，右上；*/

            String leftDouw = rect[0]+""+rect[1];
            String leftUp = rect[0]+""+rect[3];
            String rightDown = rect[2]+""+rect[1];
            String rightUp = rect[2]+""+rect[3];

            /*下面用四个if语句来清除重复的坐标点，
            集合HashSet不允许元素重复；
            如何是偶数个坐标点，for循环完之后就会清除完，
            如果能拼接成一个大的完美矩形，最后就只剩下四个顶点坐标；*/
            if (!set.add(leftDouw)) set.remove(leftDouw);
            if (!set.add(leftUp)) set.remove(leftUp);
            if (!set.add(rightDown)) set.remove(rightDown);
            if (!set.add(rightUp)) set.remove(rightUp);

        }

        /*
        上面的for循环完了之后，如果就是删除了所有的重复偶数次节点
        然后下面就是判断是不是包含了完美矩形的四个顶点，或者说存在
        重复次数为奇数的节点，就会导致集合长度不是4；
        此if语句旨在判断是否有重合的矩形或者是说完美矩形是残缺的；
         */
        if (!set.contains(mostLeft+""+mostDown)||
                !set.contains(mostLeft+""+mostUp)||
                !set.contains(mostRight+""+mostDown)||
                !set.contains(mostRight+""+mostUp)||
                set.size()!=4){
            return false;

        }

        return area == (mostUp - mostDown) * (mostRight - mostLeft);
    }
}
