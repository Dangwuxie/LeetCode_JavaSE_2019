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
        int[] arr = {3,4,3,1,5,3,6,2,7};
        int[] arr2 = {3,1,3,4,3,5,3,2,2};
        int[][] res = MinIndex3.findMinIndex(arr2);
        int r = 1;
        for (int[] o:res){
            System.out.print(r+":"+o[0]+" "+o[1]);
            System.out.println();
            r++;
        }
    }
}
