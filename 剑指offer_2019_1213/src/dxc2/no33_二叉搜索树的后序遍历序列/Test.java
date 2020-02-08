package dxc2.no33_二叉搜索树的后序遍历序列;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/7 20:07
 */
public class Test {

    public static void main(String[] args) {

        int[] arrs = new int[]{5,7,6,9,11,10,8};
        int[] arrs2 = new int[]{7,4,6,5};

        System.out.println(IsLastOrderOfBST.isLastOrderOfBST(arrs,0,arrs.length));
        System.out.println(IsLastOrderOfBST.isLastOrderOfBST(arrs2,0,arrs2.length));
    }
}
