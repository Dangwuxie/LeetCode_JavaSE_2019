package dxc.no8_单调栈结构;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/29 23:03
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,6,2,7};
        int[][] res = MinIndex1.findMinIndex(arr);
        for (int[] o:res){
            System.out.print(o[0]+" "+o[1]);
            System.out.println();
        }
    }
}
