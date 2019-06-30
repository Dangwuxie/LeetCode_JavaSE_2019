/**
 * @author Dangxuchao
 * @Title: PrintAllFolds
 * @ProjectName 第九章：其他问题
 * @Description: 折纸问题：
 * 二叉树的应用
 * 解析：典型的满二叉树结构，每折叠依次就会在原来的折痕两边多出一个折痕，一个为下，一个为上；
 * 举个例子：
 * 第一次：                下
 * 第二次：         下          上
 * 第三次：     下   上     下    上
 *
 * 从上到下打印折叠方向的过程，就是二叉树的中序遍历；
 * 从折纸的左边向右观看，每次折叠后多出来的两个折痕，左边总是下，右边总是上；由此看来规律已经很明显了；
 * @date 2019/6/30 17:35
 */
public class PrintAllFolds {
    public static void main(String[] args) {
        printAllFolds(3);
    }
    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }

    public static void printProcess(int i,int N,boolean down){
        if (i > N){
            return;
        }
        printProcess(i+1,N,true);
        System.out.print(down ? "下":"上");
        printProcess(i+1,N,false);
    }
}
