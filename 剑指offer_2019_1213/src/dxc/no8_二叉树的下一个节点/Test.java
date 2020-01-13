package dxc.no8_二叉树的下一个节点;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/13 12:42
 */
public class Test {

    public static void main(String[] args) {
        TriTreeNode n1 = new TriTreeNode(1);
        TriTreeNode n2 = new TriTreeNode(2);
        TriTreeNode n3 = new TriTreeNode(3);
        TriTreeNode n4 = new TriTreeNode(4);

        TriTreeNode n5 = new TriTreeNode(5);
        TriTreeNode n6 = new TriTreeNode(6);
        TriTreeNode n7 = new TriTreeNode(7);
        TriTreeNode n8 = new TriTreeNode(8);

        TriTreeNode n9 = new TriTreeNode(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;



        n3.left = n6;
        n3.right = n7;


        n5.left = n8;
        n5.right = n9;

        n2.parent = n1;
        n3.parent = n1;
        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;

        n8.parent = n5;
        n9.parent = n5;

        System.out.println(BinTreeNextNode.getNextNode(n1).value);
        System.out.println(BinTreeNextNode.getNextNode(n4).value);
        System.out.println(BinTreeNextNode.getNextNode(n9).value);
        System.out.println(BinTreeNextNode.getNextNode(n7).value);
        /*
        *
        * Exception in thread "main" java.lang.NullPointerException
	        at dxc.no8_二叉树的下一个节点.Test.main(Test.java:53)
            6
            2
            1
        * */
    }
}
