package com.dxc.no2_binaryTreePrintEdge;

/**
 * @author 灵魂编程者
 * @Title: PrintEdge1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/18 21:23
 */
/*
* 思路，分成三步，
* 1、从头节点开始顺着左边一直打印下去
* 2、打印叶子节点中加在两个边界节点中间的两个节点
* 3、从叶子节点的最右端顺着右边界打印上去
* 实现过程，新建一个二维数组，n行两列，
* 第一列保存左边界节点，第二列右边界节点(注意右边界节点保存方式)，
* 因为每一行第一个保存的绝对是当前行的左边界节点；
* 第二列要保存当前行的最后一个节点，所以需要每一次遍历的时候更改一次
*
* */
public class PrintEdge1 {
    public static void printEdge1(Node head){
        if (head == null){
            return;
        }

        //先求出当前树的深度，决定创建的二维数组的行数
        //每一行两个节点，第一个是左边界节点，第二个是有边界节点
        int maxLength = getMaxLength(head,0);
        Node[][] nodeMap = new Node[maxLength][2];
        //下面就是要从头节点开始设置nodeMap了，从第一行开始给数组添加节点
        setEdgeMap(nodeMap,head,0);

        //设置完后，开始遍历；
        //先遍历左边界的
        for (int i=0;i!=nodeMap.length;i++){
            System.out.print(nodeMap[i][0].value+" ");
        }
        System.out.print("===");
        //再遍历夹在中间的叶子节点
        printLeafNotEdge(nodeMap,head,0);
        System.out.print("===");
        //最后倒着往上遍历右边界节点
        for (int i=nodeMap.length-1;i>=0;i--){
            System.out.print(nodeMap[i][1].value+" ");
        }
    }

    public static int getMaxLength(Node head,int h){
        //当递归到最后一层的时候，返回最大值，就是二维数组的行数;
        if (head == null){
            return h;
        }

        return Math.max(getMaxLength(head.left,h+1),getMaxLength(head.right,h+1));
    }

    public static void setEdgeMap(Node[][] nodeMap,Node head,int h){
        if (head == null)return;
        //从头节点开始遍历
        //首先，这是一个递归方法，来设定每一层的两个节点
        nodeMap[h][0] = nodeMap[h][0]==null?head : nodeMap[h][0];
        //第一个节点一定是当前行最左边的元素，哪怕后面递归，也不会改变当前第h行的第一个节点
        nodeMap[h][1] = head;
        setEdgeMap(nodeMap,head.left,h+1);
        setEdgeMap(nodeMap,head.right,h+1);
    }
    public static void printLeafNotEdge(Node[][] nodeMap,Node head,int h){
        //叶子节点，首先不等于当前层的左右边界，其次，没有左右子节点
        if (head == null)return;
        if (head!=nodeMap[h][0] && head!=nodeMap[h][1] && head.left==null && head.right==null){
            System.out.print(head.value+" ");
        }
        printLeafNotEdge(nodeMap,head.left,h+1);
        printLeafNotEdge(nodeMap,head.right,h+1);
    }
}
