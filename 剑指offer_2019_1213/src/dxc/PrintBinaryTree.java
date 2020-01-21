package dxc;

/**
 * @author dxc
 * @Title: PrintBinaryTree
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/12 21:04
 */
public class PrintBinaryTree {

    public static void printBinaryTree(BinTreeNode head){

        if (head == null){
            return;
        }

        System.out.print(head.value+"-");
        printBinaryTree(head.left);
        printBinaryTree(head.rigth);

    }
}
